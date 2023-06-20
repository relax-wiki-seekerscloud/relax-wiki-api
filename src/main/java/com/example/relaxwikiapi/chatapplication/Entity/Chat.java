package com.example.relaxwikiapi.chatapplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatIndex;

    @ManyToOne
    @JoinColumn(name = "ChatID", referencedColumnName = "ChatID")
    private ChatIDsInfo chatIDsInfo;

    private String message;

    private int messageOwnerId;

    private LocalDateTime timeStamp;

}
