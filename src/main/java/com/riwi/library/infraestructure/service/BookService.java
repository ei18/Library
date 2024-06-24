package com.riwi.library.infraestructure.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookAllInfoResponse;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.domain.entities.Book;
import com.riwi.library.domain.repositories.BookRepository;
import com.riwi.library.infraestructure.abstract_service.IBookService;
import com.riwi.library.infraestructure.mappers.BookMapper;
import com.riwi.library.utils.exception.BadRequestException;
import com.riwi.library.utils.message.ErrorMessages;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookService implements IBookService{

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponse create(BookRequest request) {
       Book book = this.bookMapper.bookRequestToBook(request);

       return bookMapper.bookToBookResponse(this.bookRepository.save(book));
    }

    @Override
    public BookResponse get(Long id) {
       Book bookGet = this.bookRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Book")));

        return bookMapper.bookToBookResponse(bookGet);        
    }

    @Override
    public Page<BookResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.bookRepository.findAll(pagination)
                .map(bookMapper::bookToBookResponse);
    }

    @Override
    public BookResponse update(BookRequest request, Long id) {
        Book book = this.bookRepository.findById(id)
                    .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Book")));

        Book bookRequest = bookMapper.bookRequestToBook(request);
        bookRequest.setId(book.getId());  
        
        return this.bookMapper.bookToBookResponse(this.bookRepository.save(bookRequest));
    }

    @Override
    public void delete(Long id) {
        Book book = this.bookRepository.findById(id)
                    .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Book")));

        this.bookRepository.deleteById(id);            
    }
  
    @Override
    public BookAllInfoResponse findById(Long id){
        return this.bookRepository.findById(id)
                  .map(bookMapper::bookToBookAllInfoResponse)
                  .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("Book")));  
    }
}
