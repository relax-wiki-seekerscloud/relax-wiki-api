package com.example.relaxwikiapi.chatapplication.Service;

import com.example.relaxwikiapi.chatapplication.Controller.ChatIDsInfoController;
import com.example.relaxwikiapi.chatapplication.Entity.Chat;
import com.example.relaxwikiapi.chatapplication.Entity.ChatIDsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chatIdInfo")
public class ChatIDsInfo_Service {

    @Autowired
    private ChatIDsInfoController chatIDsInfoController;

    @GetMapping("/hasChat/{UserId}/{HotelId}")
    public int hasChat(@PathVariable int UserId,@PathVariable int HotelId){
        return this.chatIDsInfoController.hasChat(UserId,HotelId);
    }

    @PostMapping("/createChat/{UserId}/{HotelId}")
    public int createChat(@PathVariable int UserId,@PathVariable int HotelId){
        return this.chatIDsInfoController.createChat(UserId,HotelId);
    }

    @GetMapping("/requestChat/{UserId}/{HotelId}")
    public List<Chat> requestChat(@PathVariable int UserId, @PathVariable int HotelId){

        return this.chatIDsInfoController.requestChat(UserId,HotelId);
    }

    @GetMapping("/getChatIDsInfoById/{chatId}")
    public ChatIDsInfo getChatIDsInfoById(@PathVariable int chatId){
        return this.chatIDsInfoController.getChatIDsInfoById(chatId);
    }



}
