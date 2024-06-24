package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.response.LoanResponse;

public interface ILoanService extends CrudServices<LoanRequest, LoanResponse, Long>{
}
