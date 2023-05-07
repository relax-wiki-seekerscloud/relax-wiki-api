package com.example.relaxwikiapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserSignUpDTO {
    @NotEmpty(message = "First name is required.")
    @Size(min = 2, message = "Invalid first name.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    @Size(min = 2, message = "Invalid last name.")
    private String lastName;

    @NotEmpty(message = "Email is required.")
    @Email(message = "Invalid email.")
    private String email;

    @NotEmpty(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    public UserSignUpDTO(String userFirstName, String userLastName, String userEmail, String userPassword) {
        this.firstName = userFirstName;
        this.lastName = userLastName;
        this.email = userEmail;
        this.password = userPassword;
    }

    public UserSignUpDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
