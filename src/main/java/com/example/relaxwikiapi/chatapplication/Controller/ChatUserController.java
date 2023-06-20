package com.example.relaxwikiapi.chatapplication.Controller;

import com.example.relaxwikiapi.chatapplication.Entity.UserInfo;
import com.example.relaxwikiapi.chatapplication.Exception.ResourceNotFoundException;
import com.example.relaxwikiapi.chatapplication.Repository.UserInfo_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChatUserController {

    @Autowired
    private UserInfo_Repository userInfoRepository;

    public ResponseEntity<String> registerUser(UserInfo userInfo) {
    UserInfo existingUser = userInfoRepository.findByUserName(userInfo.getUserName());
    if (existingUser != null) {
        return ResponseEntity.badRequest().body("User with name " + userInfo.getUserName() + " already exists");
    }
    userInfoRepository.save(userInfo);
    return ResponseEntity.ok("User registered successfully");
    }

    public List<UserInfo> getAllUser(){
        return this.userInfoRepository.findAll();
    }

    public UserInfo getUserById(int Id){
        return this.userInfoRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User Does Not Exists with id: "+Id));
    }

    public int getUserIdByUserName(String userName){
        return this.userInfoRepository.findByUserName(userName).getUserID();
    }



}
