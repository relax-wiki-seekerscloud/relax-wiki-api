package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.dto.AuthenticationRequest;
import com.example.relaxwikiapi.dto.RegisterRequest;
import com.example.relaxwikiapi.dto.UserSignUpDTO;
import com.example.relaxwikiapi.response.AuthenticationResponse;
import com.example.relaxwikiapi.response.MessageResponse;
import com.example.relaxwikiapi.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/signup")
    public ResponseEntity<?> register(
            @RequestBody UserSignUpDTO userSignUpDTO
    ) {
        String add = this.service.register(userSignUpDTO);
        if(Objects.equals(add, "Success")){
            return ResponseEntity.ok(new MessageResponse("Success"));
        }
        else if(Objects.equals(add, "Email Exists")){
            return ResponseEntity.badRequest().body(new MessageResponse("Email Exists"));
        }
        return ResponseEntity.internalServerError().body(new MessageResponse("Something went wrong"));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("login");
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
}