package com.riwi.library.infraestructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.library.api.dto.request.ReservationUpdateRequest;
import com.riwi.library.api.dto.response.ReservationAllInfoResponse;
import com.riwi.library.api.dto.response.ReservationResponse;
import com.riwi.library.domain.entities.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mapping(target = "id", ignore = true)
    Reservation reservationRequestToReservation(Reservation request);

    @Mapping(target = "id", ignore = true)
    Reservation reservationUpdateRequestToReservation(ReservationUpdateRequest request);

    ReservationAllInfoResponse reservationToReservationAllInfoResponse(Reservation reservation);

    ReservationResponse reservationToReservationResponse(Reservation reservation);
}
