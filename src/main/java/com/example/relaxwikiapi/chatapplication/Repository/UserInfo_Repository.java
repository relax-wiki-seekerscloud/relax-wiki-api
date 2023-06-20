package com.example.relaxwikiapi.chatapplication.Repository;

import com.example.relaxwikiapi.chatapplication.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfo_Repository extends JpaRepository<UserInfo,Integer> {

    UserInfo findByUserName(String userName);

}
