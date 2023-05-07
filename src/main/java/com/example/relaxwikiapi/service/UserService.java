package com.example.relaxwikiapi.service;
import com.example.relaxwikiapi.dto.UserSignUpDTO;
import com.example.relaxwikiapi.entity.User;
import com.example.relaxwikiapi.entity.UserAddress;

import java.util.List;

public interface UserService {
    User addUser(User user);
    String addUser(UserSignUpDTO userDTO);
    List<User> getAllUsers();

    User getUserById(Long id);
    User updateUserFirstName(Long id, String firstName);
    User updateUserLastName(Long id, String lastName);
    User updateUserEmail(Long id, String email);
    User updateUserPhoneNo(Long id, String phoneNo);
    User updateUserGender(Long id, String gender);
    User updateUserAddress(Long userId, Long addressId, UserAddress updatedAddress);
    User updatePassword(Long id, String password);


}
