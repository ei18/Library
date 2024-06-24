package com.riwi.library.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.library.api.dto.request.BookRequest;
import com.riwi.library.api.dto.response.BookAllInfoResponse;
import com.riwi.library.api.dto.response.BookResponse;
import com.riwi.library.infraestructure.abstract_service.IBookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
@Tag(name = "Book")
public class BookController {
    private final IBookService bookService;

    @Operation(
        summary = "List all books with pagination",
        description = "You must submit the page and the page size to get all the corresponding books")
    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){
        return  ResponseEntity.ok(this.bookService.getAll(page -1, size));
    }

    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @Operation(
            summary = "List a book by id",
            description = "You must send the id of the book to search for")     
    @GetMapping(path = "{id}")
        public ResponseEntity<BookAllInfoResponse> get(@PathVariable Long id){
            return ResponseEntity.ok(this.bookService.findById(id));
        }

    @Operation(
        summary = "Create a book",
        description = "Create a book")  
    @PostMapping
    public ResponseEntity<BookResponse> create(@Validated @RequestBody BookRequest request){
        return ResponseEntity.ok(this.bookService.create(request));
    }
    
    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Update a book",
        description = "Update a book")  
    @PutMapping(path = "{id}")
    public ResponseEntity<BookResponse> update(@Validated @RequestBody BookRequest request, @PathVariable Long id){
        return ResponseEntity.ok(this.bookService.update(request, id));
    }

    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
        summary = "Delete a book by id",
        description = "Delete a book by id")  
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
