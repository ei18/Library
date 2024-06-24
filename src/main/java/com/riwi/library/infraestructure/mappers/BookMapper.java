package com.riwi.library.infraestructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookAllInfoResponse;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.domain.entities.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Book bookRequestToBook(BookRequest request);

    BookAllInfoResponse bookToBookAllInfoResponse(Book book);

    BookResponse bookToBookResponse(Book book);
}
