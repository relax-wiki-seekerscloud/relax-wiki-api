package com.example.relaxwikiapi.service;



import com.example.relaxwikiapi.config.JwtService;
import com.example.relaxwikiapi.dto.AuthenticationRequest;
import com.example.relaxwikiapi.dto.RegisterRequest;
import com.example.relaxwikiapi.dto.UserSignUpDTO;
import com.example.relaxwikiapi.entity.*;
import com.example.relaxwikiapi.repo.TokenRepository;
import com.example.relaxwikiapi.repo.UserRepository;
import com.example.relaxwikiapi.repo.VerificationTokenRepository;
import com.example.relaxwikiapi.response.AuthenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sendinblue.ApiClient;
import sendinblue.Configuration;
import sendinblue.auth.ApiKeyAuth;
import sibApi.AccountApi;
import sibApi.TransactionalEmailsApi;
import sibModel.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.channels.OverlappingFileLockException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;

    private final VerificationTokenRepository verificationTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    JavaMailSender emailSender;

    public String register(UserSignUpDTO request) {
        Optional<User> existingUser = repository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            return "Email Exists";
        }
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .isVerified(false)
                .build();

        Random random = new Random();
        long randomNumber = random.nextLong();
        String randomString = String.format("%020d", Math.abs(randomNumber));
        while(true){
            Optional<VerificationToken> token = verificationTokenRepository.findFirstByConfirmationToken(randomString);
            if(token.isPresent()){
                random = new Random();
                randomNumber = random.nextLong();
                randomString = String.format("%020d", Math.abs(randomNumber));
            }else{
                break;
            }
        }
        try{
            VerificationToken verificationToken = new VerificationToken(null, randomString, LocalDateTime.now(), user, false);
            ApiClient defaultClient = Configuration.getDefaultApiClient();
            ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
            apiKey.setApiKey("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");
            TransactionalEmailsApi emailApi = new TransactionalEmailsApi();
            SendSmtpEmail email = new SendSmtpEmail();
            email.setSender(new SendSmtpEmailSender().email("relaxwiki1@gmail.com").name("Relax Wiki"));
            email.setTo(new ArrayList<>(Collections.singletonList(new SendSmtpEmailTo().email(user.getEmail()))));
            email.setSubject("Let's verify your account!");
            email.setTextContent("Please verify your email by going to http://localhost:4200/security/verify-email/"+verificationToken.getConfirmationToken());
            CreateSmtpEmail result = emailApi.sendTransacEmail(email);
            repository.save(user);
            verificationTokenRepository.save(verificationToken);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return "Success";
    }

    public boolean verifyUser(String tokenString){
        Optional<VerificationToken> token = verificationTokenRepository.findFirstByConfirmationToken(tokenString);
        if(token.isPresent()){
            VerificationToken tokenEntity = token.get();

            if(tokenEntity.isUsed()){
                return false;
            }
            tokenEntity.setUsed(true);
            tokenEntity.getUser().setVerified(true);
            verificationTokenRepository.save(tokenEntity);
            return true;
        }
        return false;
    }

    public boolean getNewVerificationToken(String userEmail) {
        Random random = new Random();
        long randomNumber = random.nextLong();
        String randomString = String.format("%020d", Math.abs(randomNumber));
        while(true){
            Optional<VerificationToken> token = verificationTokenRepository.findFirstByConfirmationToken(randomString);
            if(token.isPresent()){
                random = new Random();
                randomNumber = random.nextLong();
                randomString = String.format("%020d", Math.abs(randomNumber));
            }else{
                break;
            }
        }
        try{
            Optional<User> userOptional = repository.findByEmail(userEmail);
            if(userOptional.isEmpty()){
                throw new Exception("User Not Found");
            }
            User user = userOptional.get();
            if(user.isVerified()){
                throw new Exception("User already enabled");
            }
            VerificationToken verificationToken = new VerificationToken(null, randomString, LocalDateTime.now(), user, false);
            ApiClient defaultClient = Configuration.getDefaultApiClient();
            ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
            apiKey.setApiKey("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");
            TransactionalEmailsApi emailApi = new TransactionalEmailsApi();
            SendSmtpEmail email = new SendSmtpEmail();
            email.setSender(new SendSmtpEmailSender().email("relaxwiki1@gmail.com").name("Relax Wiki"));
            email.setTo(new ArrayList<>(Collections.singletonList(new SendSmtpEmailTo().email(user.getEmail()))));
            email.setSubject("Let's verify your account!");
            email.setTextContent("Please verify your email by going to http://localhost:4200/security/verify-email/"+verificationToken.getConfirmationToken());
            CreateSmtpEmail result = emailApi.sendTransacEmail(email);

            verificationTokenRepository.save(verificationToken);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        if(!user.isVerified()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}