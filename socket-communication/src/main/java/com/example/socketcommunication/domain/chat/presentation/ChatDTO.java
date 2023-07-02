package com.example.socketcommunication.domain.chat.presentation;

import com.example.socketcommunication.domain.chat.domain.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ChatDTO {

    private MessageType messageType;

    private Long roomId;

    private String sender;

    private String message;
}
