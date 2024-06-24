package com.riwi.library.api.dto.request;

import java.time.LocalDate;

import com.riwi.library.utils.enums.StatusLoan;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanUpdateRequest {
    @NotBlank(message = "Loan Date is required")
    private LocalDate loanDate;
    private LocalDate returnDate;
    private StatusLoan status;
}
