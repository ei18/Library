package com.riwi.library.infraestructure.mappers;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.request.LoanUpdateRequest;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.api.dto.response.LoanResponse;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.entities.Loan;
import com.riwi.library.domain.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T12:33:56-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public Loan loanRequestToLoan(LoanRequest request) {
        if ( request == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.loanDate( request.getLoanDate() );
        loan.returnDate( request.getReturnDate() );
        loan.status( request.getStatus() );

        return loan.build();
    }

    @Override
    public Loan loanUpdateRequestToLoan(LoanUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.loanDate( request.getLoanDate() );
        loan.returnDate( request.getReturnDate() );
        loan.status( request.getStatus() );

        return loan.build();
    }

    @Override
    public LoanAllInfoResponse loanToLoanAllInfoResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanAllInfoResponse.LoanAllInfoResponseBuilder loanAllInfoResponse = LoanAllInfoResponse.builder();

        loanAllInfoResponse.book( bookToBookResponse( loan.getBook() ) );
        loanAllInfoResponse.id( loan.getId() );
        loanAllInfoResponse.loanDate( loan.getLoanDate() );
        loanAllInfoResponse.returnDate( loan.getReturnDate() );
        if ( loan.getStatus() != null ) {
            loanAllInfoResponse.status( loan.getStatus().name() );
        }
        loanAllInfoResponse.user( userToUserResponse( loan.getUser() ) );

        return loanAllInfoResponse.build();
    }

    @Override
    public LoanResponse loanToLoanResponse(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder loanResponse = LoanResponse.builder();

        loanResponse.id( loan.getId() );
        loanResponse.loanDate( loan.getLoanDate() );
        loanResponse.returnDate( loan.getReturnDate() );
        if ( loan.getStatus() != null ) {
            loanResponse.status( loan.getStatus().name() );
        }

        return loanResponse.build();
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
