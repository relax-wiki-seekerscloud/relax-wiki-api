package com.example.relaxwikiapi.chatapplication.Controller;

import com.example.relaxwikiapi.chatapplication.Entity.Chat;
import com.example.relaxwikiapi.chatapplication.Repository.Chats_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private Chats_Repository chats_repository;

    public Chat saveChat(Chat chat){
        chat.setTimeStamp(LocalDateTime.now());
        return this.chats_repository.save(chat);
    }

    public List<Chat> getCurrentChat(int ChatId) {

        List<Chat> allChats = this.chats_repository.findAll();
        List<Chat> filteredChats = new ArrayList<>();
        for(Chat selectedChat:allChats){
            if(selectedChat.getChatIDsInfo().getChatID()==ChatId){
                filteredChats.add(selectedChat);
            }
        }
        return filteredChats;
    }

//    public void setCurrentChat(int currentId){
//        List<Chat> chats = this.chats_repository.findAll();
//        for(Chat selectedChat:chats){
//            if (selectedChat.getChatIDsInfo().getChatID()==currentId) {
//                this.chats_repository.save(selectedChat);
//            }else {
//                selectedChat.setIscurrentChat(false);
//                this.chats_repository.save(selectedChat);
//            }
//
//        }
//
//    }

}
