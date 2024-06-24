package com.riwi.library.api.dto.request;

import java.time.LocalDate;

import com.riwi.library.utils.enums.StatusReservation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @NotBlank(message = "Reservation Date is required")
    @Future(message = "The date is invalid, it must be greater than the current date.")
    private LocalDate reservationDate;
    private StatusReservation status;
    private Long userId;
    private Long bookId;
}
