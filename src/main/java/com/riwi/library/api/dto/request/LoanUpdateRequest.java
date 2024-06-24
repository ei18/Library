package com.riwi.library.api.dto.request;

import java.time.LocalDate;

import com.riwi.library.utils.enums.StatusLoan;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanUpdateRequest {
    @Future(message = "The date is invalid, it must be greater than the current date.")
    private LocalDate loanDate;
    private LocalDate returnDate;
    private StatusLoan status;
}
