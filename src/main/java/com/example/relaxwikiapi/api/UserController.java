package com.example.relaxwikiapi.api;

import com.example.relaxwikiapi.dto.UserDTO;
import com.example.relaxwikiapi.dto.UserSignUpDTO;
import com.example.relaxwikiapi.entity.User;
import com.example.relaxwikiapi.entity.UserAddress;
import com.example.relaxwikiapi.response.MessageResponse;
import com.example.relaxwikiapi.response.UserResponse;
import com.example.relaxwikiapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO.getUser());
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PatchMapping("/updateUserFirstName/{id}")
    public User updateUserFirstName(@PathVariable Long id, @RequestParam String firstName) {
        return userService.updateUserFirstName(id, firstName);
    }

    @PatchMapping("/updateUserLastName/{id}")
    public User updateUserLastName(@PathVariable Long id, @RequestParam String lastName) {
        return userService.updateUserLastName(id, lastName);
    }

    @PatchMapping("/updateUserEmail/{id}")
    public User updateUserEmail(@PathVariable Long id, @RequestParam String email) {
        return userService.updateUserEmail(id, email);
    }

    @PatchMapping("/updateUserPhoneNo/{id}")
    public User updateUserPhoneNo(@PathVariable Long id, @RequestParam String phoneNo) {
        return userService.updateUserPhoneNo(id, phoneNo);
    }

    @PatchMapping("/updateUserGender/{id}")
    public User updateUserGender(@PathVariable Long id, @RequestParam String gender) {
        return userService.updateUserGender(id, gender);
    }

    @PatchMapping("/updateUserAddress/{userId}/addresses/{addressId}")
    public User updateUserAddress(@PathVariable Long userId, @PathVariable Long addressId, @RequestBody UserAddress updatedAddress) {
        return userService.updateUserAddress(userId, addressId, updatedAddress);
    }

    @PatchMapping("/updateUserPassword/{id}")
    public User updatePassword(@PathVariable Long id, @RequestParam String password) {
        return userService.updatePassword(id, password);
    }

    @GetMapping("/user")
    public UserResponse getUserById(@AuthenticationPrincipal User user) {
        return new UserResponse(user.getFirstName(),user.getLastName(),user.getEmail());
    }

//    @PostMapping("/sign-up")
//    public ResponseEntity<?> signUp(@Valid @RequestBody UserSignUpDTO userSignUpDTO){
//        String add = this.userService.addUser(userSignUpDTO);
//        if(add=="Success"){
//            return ResponseEntity.ok(new MessageResponse("Success"));
//        }
//        else if(add=="Email Exists"){
//            return ResponseEntity.badRequest().body(new MessageResponse("Email Exists"));
//        }
//        return ResponseEntity.internalServerError().body(new MessageResponse("Something went wrong"));
//    }


}

