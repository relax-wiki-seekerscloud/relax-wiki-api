package com.example.relaxwikiapi.chatapplication.Repository;
import com.example.relaxwikiapi.chatapplication.Entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Chats_Repository extends JpaRepository<Chat,Integer> {
}
