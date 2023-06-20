package com.example.relaxwikiapi.chatapplication.Repository;

import com.example.relaxwikiapi.chatapplication.Entity.ChatIDsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatIDsInfo_Repository extends JpaRepository<ChatIDsInfo,Integer> {
}
