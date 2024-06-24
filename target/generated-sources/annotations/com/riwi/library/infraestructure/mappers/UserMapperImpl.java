package com.riwi.library.infraestructure.mappers;

import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.LoanResponse;
import com.riwi.library.api.dto.response.ReservationResponse;
import com.riwi.library.api.dto.response.UserAllInfoResponse;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.domain.entities.Loan;
import com.riwi.library.domain.entities.Reservation;
import com.riwi.library.domain.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T11:41:55-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userRequestToUser(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setEmail( request.getEmail() );
        user.setFullName( request.getFullName() );
        user.setRole( request.getRole() );

        return user;
    }

    @Override
    public UserAllInfoResponse userToUserAllInfoResponse(User response) {
        if ( response == null ) {
            return null;
        }

        UserAllInfoResponse.UserAllInfoResponseBuilder userAllInfoResponse = UserAllInfoResponse.builder();

        userAllInfoResponse.id( response.getId() );
        userAllInfoResponse.username( response.getUsername() );
        userAllInfoResponse.email( response.getEmail() );
        userAllInfoResponse.fullName( response.getFullName() );
        userAllInfoResponse.role( response.getRole() );
        userAllInfoResponse.reservations( reservationListToReservationResponseList( response.getReservations() ) );
        userAllInfoResponse.loans( loanListToLoanResponseList( response.getLoans() ) );

        return userAllInfoResponse.build();
    }

    @Override
    public UserResponse userToUserResponse(User user) {
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

    protected ReservationResponse reservationToReservationResponse(Reservation reservation) {
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
}
