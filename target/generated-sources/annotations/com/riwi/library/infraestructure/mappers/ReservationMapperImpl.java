package com.riwi.library.infraestructure.mappers;

import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.request.ReservationUpdateRequest;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.api.dto.response.ReservationAllInfoResponse;
import com.riwi.library.api.dto.response.ReservationResponse;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.entities.Reservation;
import com.riwi.library.domain.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T11:41:55-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation reservationRequestToReservation(ReservationRequest request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.reservationDate( request.getReservationDate() );
        reservation.status( request.getStatus() );

        return reservation.build();
    }

    @Override
    public Reservation reservationUpdateRequestToReservation(ReservationUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.reservationDate( request.getReservationDate() );
        reservation.status( request.getStatus() );

        return reservation.build();
    }

    @Override
    public ReservationAllInfoResponse reservationToReservationAllInfoResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationAllInfoResponse.ReservationAllInfoResponseBuilder reservationAllInfoResponse = ReservationAllInfoResponse.builder();

        reservationAllInfoResponse.id( reservation.getId() );
        reservationAllInfoResponse.reservationDate( reservation.getReservationDate() );
        if ( reservation.getStatus() != null ) {
            reservationAllInfoResponse.status( reservation.getStatus().name() );
        }
        reservationAllInfoResponse.user( userToUserResponse( reservation.getUser() ) );
        reservationAllInfoResponse.book( bookToBookResponse( reservation.getBook() ) );

        return reservationAllInfoResponse.build();
    }

    @Override
    public ReservationResponse reservationToReservationResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse.ReservationResponseBuilder reservationResponse = ReservationResponse.builder();

        reservationResponse.id( reservation.getId() );
        reservationResponse.reservationDate( reservation.getReservationDate() );
        if ( reservation.getStatus() != null ) {
            reservationResponse.status( reservation.getStatus().name() );
        }

        return reservationResponse.build();
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.username( user.getUsername() );
        userResponse.email( user.getEmail() );
        userResponse.fullName( user.getFullName() );
        userResponse.role( user.getRole() );

        return userResponse.build();
    }

    protected BookResponse bookToBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        bookResponse.id( book.getId() );
        bookResponse.title( book.getTitle() );
        bookResponse.author( book.getAuthor() );
        bookResponse.publicationYear( book.getPublicationYear() );
        bookResponse.genre( book.getGenre() );
        bookResponse.isbn( book.getIsbn() );

        return bookResponse.build();
    }
}
