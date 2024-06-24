package com.riwi.library.infraestructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.request.LoanUpdateRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.api.dto.response.LoanResponse;
import com.riwi.library.domain.entities.Loan;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "user", ignore = true)
    Loan loanRequestToLoan(LoanRequest request);

    @Mapping(target = "id", ignore = true)
    Loan loanUpdateRequestToLoan(LoanUpdateRequest request);

    LoanAllInfoResponse loanToLoanAllInfoResponse(Loan loan);

    LoanResponse loanToLoanResponse(Loan loan);
}
