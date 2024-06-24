package com.riwi.library.infraestructure.mappers;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookAllInfoResponse;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.api.dto.response.LoanResponse;
import com.riwi.library.api.dto.response.ReservationResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.entities.Loan;
import com.riwi.library.domain.entities.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T08:57:34-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book bookRequestToBook(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.author( request.getAuthor() );
        book.genre( request.getGenre() );
        book.isbn( request.getIsbn() );
        book.publicationYear( request.getPublicationYear() );
        book.title( request.getTitle() );

        return book.build();
    }

    @Override
    public BookAllInfoResponse bookToBookAllInfoResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookAllInfoResponse.BookAllInfoResponseBuilder bookAllInfoResponse = BookAllInfoResponse.builder();

        bookAllInfoResponse.author( book.getAuthor() );
        bookAllInfoResponse.genre( book.getGenre() );
        bookAllInfoResponse.id( book.getId() );
        bookAllInfoResponse.isbn( book.getIsbn() );
        bookAllInfoResponse.loans( loanListToLoanResponseList( book.getLoans() ) );
        bookAllInfoResponse.publicationYear( book.getPublicationYear() );
        bookAllInfoResponse.reservations( reservationListToReservationResponseList( book.getReservations() ) );
        bookAllInfoResponse.title( book.getTitle() );

        return bookAllInfoResponse.build();
    }

    @Override
    public BookResponse bookToBookResponse(Book book) {
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

    protected LoanResponse loanToLoanResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder loanResponse = LoanResponse.builder();

        loanResponse.id( loan.getId() );
        loanResponse.loanDate( loan.getLoanDate() );
        loanResponse.returnDate( loan.getReturnDate() );
        loanResponse.status( loan.getStatus() );

        return loanResponse.build();
    }

    protected List<LoanResponse> loanListToLoanResponseList(List<Loan> list) {
        if ( list == null ) {
            return null;
        }

        List<LoanResponse> list1 = new ArrayList<LoanResponse>( list.size() );
        for ( Loan loan : list ) {
            list1.add( loanToLoanResponse( loan ) );
        }

        return list1;
    }

    protected ReservationResponse reservationToReservationResponse(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse.ReservationResponseBuilder reservationResponse = ReservationResponse.builder();

        reservationResponse.id( reservation.getId() );
        reservationResponse.reservationDate( reservation.getReservationDate() );
        reservationResponse.status( reservation.getStatus() );

        return reservationResponse.build();
    }

    protected List<ReservationResponse> reservationListToReservationResponseList(List<Reservation> list) {
        if ( list == null ) {
            return null;
        }

        List<ReservationResponse> list1 = new ArrayList<ReservationResponse>( list.size() );
        for ( Reservation reservation : list ) {
            list1.add( reservationToReservationResponse( reservation ) );
        }

        return list1;
    }
}
