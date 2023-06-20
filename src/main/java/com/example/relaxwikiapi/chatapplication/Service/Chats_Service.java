package com.example.relaxwikiapi.chatapplication.Service;

import com.example.relaxwikiapi.chatapplication.Controller.ChatController;
import com.example.relaxwikiapi.chatapplication.Entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chat")
public class Chats_Service {

    @Autowired
    private ChatController chatController;

    @PostMapping("/saveChat")
    public Chat saveChat(@RequestBody Chat chat){
        return this.chatController.saveChat(chat);
    }

    @GetMapping("/getCurrentChat/{currentChatId}")
    public List<Chat> getCurrentChat(@PathVariable int currentChatId){
        return this.chatController.getCurrentChat(currentChatId);
    }

//    @PutMapping("/setCurrentChat/{currentId}")
//    public void setCurrentChat(@PathVariable int currentId){
//        this.chatController.setCurrentChat(currentId);
//    }


}
