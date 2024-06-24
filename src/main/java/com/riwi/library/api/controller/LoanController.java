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

import com.riwi.library.api.dto.request.LoanRequest;
import com.riwi.library.api.dto.request.LoanUpdateRequest;
import com.riwi.library.api.dto.response.LoanAllInfoResponse;
import com.riwi.library.infraestructure.abstract_service.ILoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/loans")
@AllArgsConstructor
@Tag(name = "Loan")
public class LoanController {
    private final ILoanService loanService;

    @Operation(
            summary = "List all loans with pagination",
            description = "You must submit the page and the page size to get all the corresponding loans")
    @GetMapping
    public ResponseEntity<Page<LoanAllInfoResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){
        return  ResponseEntity.ok(this.loanService.getAll(page -1, size));
    }

    @ApiResponse(responseCode = "400", description = "When the ID is invalid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @Operation(
            summary = "List a loan by id",
            description = "You must send the id of the loan to search for")
    @GetMapping(path = "{id}")
    public ResponseEntity<LoanAllInfoResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.loanService.findById(id));
    }

    @Operation(
            summary = "Create a loan",
            description = "Create a loan")
    @PostMapping
    public ResponseEntity<LoanAllInfoResponse> create(@Validated @RequestBody LoanRequest request){
        return ResponseEntity.ok(this.loanService.create(request));
    }

    @ApiResponse(responseCode = "400", description = "When the request is invalid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
            summary = "Update a loan",
            description = "Update a loan")
    @PutMapping(path = "{id}")
    public ResponseEntity<LoanAllInfoResponse> update(
            @Validated
            @RequestBody LoanUpdateRequest request,
            @PathVariable Long id){
        return ResponseEntity.ok(this.loanService.updateRequest(request, id));
    }

    @ApiResponse(responseCode = "400", description = "When the id is invalid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(
            summary = "Delete a loan by id",
            description = "Delete a loan by id")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.loanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
