package com.example.relaxwikiapi.chatapplication.Service;

import com.example.relaxwikiapi.chatapplication.Controller.ChatUserController;
import com.example.relaxwikiapi.chatapplication.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/UserController")
public class UserInfo_Service {

    @Autowired
    private ChatUserController chatUserController;

    @PostMapping("/Register")
    public ResponseEntity<String> registeruser(@RequestBody UserInfo userInfo){
        return this.chatUserController.registerUser(userInfo);
    }

    @GetMapping("/getAllUser")
    public List<UserInfo> userInfoList(){
        return this.chatUserController.getAllUser();
    }

    @GetMapping("/getUserById/{id}")
    public UserInfo getUserById(@PathVariable int id){
        return this.chatUserController.getUserById(id);
    }

    @GetMapping("/getUserIdByUserName/{userName}")
    public int getUserIdByUserName(@PathVariable String userName){
        return this.chatUserController.getUserIdByUserName(userName);
    }


}
