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
    @NotEmpty(message = "Login is required")
    private String login;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
