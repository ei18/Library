package com.riwi.library.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 100, message = "The title must have a maximum of 100 characters.")
    private String title;
    @NotBlank(message = "Author is required")
    @Size(min = 1, max = 100, message = "The author must have a maximum of 100 characters.")
    private String author;
    @NotNull(message = "Publication year is required")
    @Max(value = 2025, message = "The year of publication must have a maximum of 11 characters.")
    private Integer publicationYear;
    @NotBlank(message = "Genre is required")
    @Size(min = 1, max = 50, message = "The genre must have a maximum of 50 characters.")
    private String genre;
    @NotBlank(message = "isbn is required")
    @Size(min = 1, max = 20, message = "The isbn must have a maximum of 20 characters.")
    private String isbn;
}
