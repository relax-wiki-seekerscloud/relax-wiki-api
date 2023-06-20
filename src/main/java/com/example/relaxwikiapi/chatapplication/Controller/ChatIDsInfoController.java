package com.example.relaxwikiapi.chatapplication.Controller;

import com.example.relaxwikiapi.chatapplication.Entity.Chat;
import com.example.relaxwikiapi.chatapplication.Entity.ChatIDsInfo;
import com.example.relaxwikiapi.chatapplication.Repository.ChatIDsInfo_Repository;
import com.example.relaxwikiapi.chatapplication.Service.Chats_Service;
import com.example.relaxwikiapi.chatapplication.Service.HotelInfo_Service;
import com.example.relaxwikiapi.chatapplication.Service.UserInfo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChatIDsInfoController {

    @Autowired
    private ChatIDsInfo_Repository chatIDsInfo_repository;

    @Autowired
    private UserInfo_Service userInfo_service;

    @Autowired
    private HotelInfo_Service hotelInfo_service;

    @Autowired
    private Chats_Service chats_service;

    public int hasChat(int UserId,int HotelId){
        List<ChatIDsInfo> chatIDsInfoList = this.chatIDsInfo_repository.findAll();
        for(ChatIDsInfo chatIDsInfo:chatIDsInfoList){
            if(chatIDsInfo.getUserInfo().getUserID()==UserId && chatIDsInfo.getHotelInfo().getHotelID()==HotelId){
                return chatIDsInfo.getChatID();
            }
        }
        return 0; // return 0 if it does not have a chat
    }

    public ChatIDsInfo getChatIDsInfoById(int id){
        List<ChatIDsInfo> chatIDsInfoList = this.chatIDsInfo_repository.findAll();
        for(ChatIDsInfo selectedChatIdInfo:chatIDsInfoList){
            if(selectedChatIdInfo.getChatID()==id){
                return selectedChatIdInfo;
            }
        }
        return null;
    }

    public int createChat(int UserId,int HotelId){

        int chatId = hasChat(UserId,HotelId);

        if(chatId==0){

            ChatIDsInfo chatIDsInfo = new ChatIDsInfo();
            chatIDsInfo.setUserInfo(this.userInfo_service.getUserById(UserId));
            chatIDsInfo.setHotelInfo(this.hotelInfo_service.getHotelById(HotelId));     /////////////////
            this.chatIDsInfo_repository.save(chatIDsInfo);

            Chat c = new Chat();
            c.setChatIDsInfo(chatIDsInfo);
            this.chats_service.saveChat(c);

            return chatIDsInfo.getChatID();
        }
        else{
            return chatId;
        }
    }

    public List<Chat> requestChat(int UserId,int HotelId){
        int id = 0;
        if(hasChat(UserId,HotelId)>0){
            id = this.hasChat(UserId,HotelId);
        }
        else {
            id =  this.createChat(UserId,HotelId);
        }
        return this.chats_service.getCurrentChat(id);
    }
}