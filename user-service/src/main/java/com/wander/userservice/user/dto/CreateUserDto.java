package com.wander.userservice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

    @Size(min=4, max=15, message = "username size should be between 4 to 15")
    private String username;

    @NotBlank(message = "Name is mandatory")
    @Size(min=4, max=50, message = "Name size should be between 4 to 50")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please enter valid email address")
    @Size(min=5, max=50, message = "Email size should be between 5 to 50")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min=5, max=20, message = "Password size should be between 5 to 20")
    private String password;
}
