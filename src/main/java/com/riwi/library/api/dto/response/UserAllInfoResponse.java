package com.riwi.library.api.dto.response;

import com.riwi.library.utils.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAllInfoResponse {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private Role role;
    private List<ReservationResponse> reservations;
    private List<LoanResponse> loans;
}

