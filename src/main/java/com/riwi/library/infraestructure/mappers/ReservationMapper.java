package com.riwi.library.infraestructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.library.domain.entities.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mapping(target = "id", ignore = true)
    Reservation reservationRequestToReservation(Reservation request);
}
