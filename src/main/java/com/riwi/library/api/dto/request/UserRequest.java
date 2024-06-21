package com.riwi.library.api.dto.request;

import com.riwi.library.utils.enums.Role;

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
public class UserRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 1, max = 50, message = "The username must have a maximum of 50 characters.")
    private String username;
    @NotBlank(message = "Password is required")
    @Size(min = 1, max = 100, message = "The password must have a maximum of 100 characters.")
    private String password;
    @NotBlank(message = "Email is required")
    @Size(min = 1, max = 100, message = "The email must have a maximum of 100 characters.")
    private String email;
    @NotBlank(message = "FullName is required")
    @Size(min = 1, max = 100, message = "The full name must have a maximum of 100 characters.")
    private String fullName;
    @NotNull(message = "Role is required")
    private Role role;
}
