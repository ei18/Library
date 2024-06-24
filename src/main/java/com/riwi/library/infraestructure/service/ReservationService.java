package com.riwi.library.infraestructure.service;


import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.request.ReservationUpdateRequest;
import com.riwi.library.api.dto.response.ReservationAllInfoResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.entities.Reservation;
import com.riwi.library.domain.entities.User;
import com.riwi.library.domain.repositories.BookRepository;
import com.riwi.library.domain.repositories.ReservationRepository;
import com.riwi.library.domain.repositories.UserRepository;
import com.riwi.library.infraestructure.abstract_service.IReservationService;
import com.riwi.library.infraestructure.mappers.ReservationMapper;
import com.riwi.library.utils.enums.StatusReservation;
import com.riwi.library.utils.exception.BadRequestException;
import com.riwi.library.utils.message.ErrorMessages;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    private final ReservationMapper reservationMapper;

    @Override
    public ReservationAllInfoResponse create(ReservationRequest request) {

        User user = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("User")));

        Book book = this.bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Book")));

        if (this.isBookAvailable(request.getBookId(), request.getReservationDate()) != 0) {
            throw new BadRequestException("The book is not available for reservation");
        }

        Reservation reservation = reservationMapper.reservationRequestToReservation(request);

        reservation.setUser(user);
        reservation.setBook(book);
        reservation.setStatus(StatusReservation.PENDING);

        return this.reservationMapper.reservationToReservationAllInfoResponse(reservationRepository.save(reservation));
    }

    @Override
    public Page<ReservationAllInfoResponse> getAll(int page, int size) {

        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.reservationRepository.findAll(pagination)
                .map(reservationMapper::reservationToReservationAllInfoResponse);
    }

    @Override
    public ReservationAllInfoResponse update(ReservationRequest request, Long id) {

        /*
         * User user = this.userRepository.findById(id)
         * .orElseThrow(() -> new
         * BadRequestException(ErrorMessages.IdNotFound("User")));
         * 
         * Book book = this.bookRepository.findById(request.getBookId())
         * .orElseThrow(() -> new
         * BadRequestException(ErrorMessages.IdNotFound("Book")));
         * 
         * if (this.isBookAvailable(request.getBookId(), request.getReservationDate())
         * != 0) {
         * throw new BadRequestException("The book is not available for reservation");
         * 
         * 
         * Reservation reservation =
         * reservationMapper.reservationRequestToReservation(request);
         * 
         * reservation.setUser(user);
         * reservation.setBook(book);
         * reservation.setId(id);
         * 
         * return reservationMapper.reservationToReservationAllInfoResponse(this.
         * reservationRepository.save(reservation));
         * 
         */

        return null;
    }

    public ReservationAllInfoResponse updateRequest(ReservationUpdateRequest request, Long id) {

        Reservation reservation = reservationMapper.reservationUpdateRequestToReservation(request);

        reservation.setId(id);

        return reservationMapper.reservationToReservationAllInfoResponse(this.reservationRepository.save(reservation));
    }

    @Override
    public void delete(Long id) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Reservation")));

        reservationRepository.deleteById(reservation.getId());

    }

    @Override
    public ReservationAllInfoResponse findById(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::reservationToReservationAllInfoResponse)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Reservation")));
    }

    private List<ReservationAllInfoResponse> entityToresponseList(List<Reservation> reservations) {
        return reservations.stream()
                .map(reservationMapper::reservationToReservationAllInfoResponse)
                .toList();
    }

    @Override
    public List<ReservationAllInfoResponse> findAllByUserId(Long userId) {
        return entityToresponseList(reservationRepository.findAllByUser_Id(userId));
    }

    @Override
    public List<ReservationAllInfoResponse> findAllByBookId(Long bookId) {
        return entityToresponseList(reservationRepository.findAllByBook_Id(bookId));
    }

    public Long isBookAvailable(Long bookId, LocalDate reservationDate) {
        return reservationRepository.countByBookIdAndReservationDate(bookId, reservationDate);
    }
}
