package com.riwi.library.infraestructure.abstract_service;

import java.util.List;

import com.riwi.library.api.dto.request.ReservationRequest;
import com.riwi.library.api.dto.request.ReservationUpdateRequest;
import com.riwi.library.api.dto.response.ReservationAllInfoResponse;

public interface IReservationService extends CrudServices<ReservationRequest, ReservationAllInfoResponse, Long>{
    ReservationAllInfoResponse findById(Long id);

    ReservationAllInfoResponse updateRequest(ReservationUpdateRequest request, Long id);

    List<ReservationAllInfoResponse> findAllByUserId(Long userId);

    List<ReservationAllInfoResponse> findAllByBookId(Long bookId);
}
