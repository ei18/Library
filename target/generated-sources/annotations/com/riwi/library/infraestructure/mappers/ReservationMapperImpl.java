package com.riwi.library.infraestructure.mappers;

import com.riwi.library.domain.entities.Reservation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-23T20:52:07-0500",
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
}
