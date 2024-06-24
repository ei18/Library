package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.response.ReservationResponse;

public interface IReservationService extends CrudServices<ReservationRequest, ReservationResponse, Long>{
    
}
