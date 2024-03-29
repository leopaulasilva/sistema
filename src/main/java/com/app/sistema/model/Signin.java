package com.app.sistema.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Signin {
    @NotEmpty(message = "Email is required")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
