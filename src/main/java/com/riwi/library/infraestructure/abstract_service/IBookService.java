package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookAllInfoResponse;
import com.riwi.library.api.dto.response.BookResponse;

public interface IBookService extends CrudServices<BookRequest, BookResponse, Long>{

    BookAllInfoResponse findById(Long id);
}
