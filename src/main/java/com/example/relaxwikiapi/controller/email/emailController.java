package com.example.relaxwikiapi.controller.email;

import com.example.relaxwikiapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class emailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail/{email}")
    public ResponseEntity<String> sendEmail(@PathVariable String email){

        boolean result = emailService.sendEmail(email);

        if(result){
            return ResponseEntity.ok("Email Sent Successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Faild To Send Email");
        }
    }

    @PostMapping("/saveSubscriber/{email}")
    public void saveSubscriber(@PathVariable String email){

        this.emailService.saveSubscriber(email);
    }
}
