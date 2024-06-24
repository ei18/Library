package com.riwi.library.infraestructure.mappers;

import com.riwi.library.domain.entities.Reservation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T08:50:38-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation reservationRequestToReservation(Reservation request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.reservationDate( request.getReservationDate() );
        reservation.status( request.getStatus() );
        reservation.user( request.getUser() );
        reservation.book( request.getBook() );

        return reservation.build();
    }
}
