package com.riwi.library.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationAllInfoResponse {
    private Long id;
    private LocalDate reservationDate;
    private String status;
    private UserResponse user;
    private BookResponse book;
}
