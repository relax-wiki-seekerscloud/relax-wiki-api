package com.example.relaxwikiapi.controller.hotel;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TKPaymentController {
    @Value("${stripe.secretKey}")
    private String stripeSecretKey;

    @PostMapping("/hotelPayment")
    public ResponseEntity<String> processHotelPayment(@RequestBody PaymentRequest paymentRequest) {
        Stripe.apiKey = stripeSecretKey;

        try {
            // Create a charge with the Stripe API
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", paymentRequest.getAmount());
            chargeParams.put("currency", "usd");
            chargeParams.put("source", paymentRequest.getToken());
            Charge charge = Charge.create(chargeParams);

            // Handle the successful payment

            return ResponseEntity.ok("Payment has been successful!");
        } catch (Exception e) {
            // Handle any errors that occurred during payment processing
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment failed. Please try again.");
        }
    }

}

class PaymentRequest {
    private String token;
    private int amount;

    // Getters and setters

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    // Constructor


    public PaymentRequest(String token, int amount) {
        this.token = token;
        this.amount = amount;
    }
}

