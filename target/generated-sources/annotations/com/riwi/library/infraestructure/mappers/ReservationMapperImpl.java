package com.riwi.library.infraestructure.mappers;

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
    date = "2024-06-24T10:55:39-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation reservationRequestToReservation(Reservation request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.book( request.getBook() );
        reservation.reservationDate( request.getReservationDate() );
        reservation.status( request.getStatus() );
        reservation.user( request.getUser() );

        return reservation.build();
    }

    @Override
    public Reservation reservationUpdateRequestToReservation(ReservationUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.reservationDate( request.getReservationDate() );
        if ( request.getStatus() != null ) {
            reservation.status( request.getStatus().name() );
        }

        return reservation.build();
    }

    @Override
    public ReservationAllInfoResponse reservationToReservationAllInfoResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationAllInfoResponse.ReservationAllInfoResponseBuilder reservationAllInfoResponse = ReservationAllInfoResponse.builder();

        reservationAllInfoResponse.book( bookToBookResponse( reservation.getBook() ) );
        reservationAllInfoResponse.id( reservation.getId() );
        reservationAllInfoResponse.reservationDate( reservation.getReservationDate() );
        reservationAllInfoResponse.status( reservation.getStatus() );
        reservationAllInfoResponse.user( userToUserResponse( reservation.getUser() ) );

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
        reservationResponse.status( reservation.getStatus() );

        return reservationResponse.build();
    }

    protected BookResponse bookToBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        bookResponse.author( book.getAuthor() );
        bookResponse.genre( book.getGenre() );
        bookResponse.id( book.getId() );
        bookResponse.isbn( book.getIsbn() );
        bookResponse.publicationYear( book.getPublicationYear() );
        bookResponse.title( book.getTitle() );

        return bookResponse.build();
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.email( user.getEmail() );
        userResponse.fullName( user.getFullName() );
        userResponse.id( user.getId() );
        userResponse.role( user.getRole() );
        userResponse.username( user.getUsername() );

        return userResponse.build();
    }
}
