package com.riwi.library.api.dto.request;

import java.time.LocalDate;

import com.riwi.library.utils.enums.StatusLoan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    @NotBlank(message = "Loan Date is required")
    private LocalDate loanDate;
    private LocalDate returnDate;
    @NotBlank(message = "Status is required")
    @Size(min = 1, max = 20, message = "The status must have a maximum of 20 characters.")
    private StatusLoan status;
}
