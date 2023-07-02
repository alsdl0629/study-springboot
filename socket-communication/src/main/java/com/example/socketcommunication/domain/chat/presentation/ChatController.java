package com.example.socketcommunication.domain.chat.presentation;

import com.example.socketcommunication.domain.chat.domain.MessageType;
import com.example.socketcommunication.domain.chat.service.ChatService;
import com.example.socketcommunication.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatController {

    private final ChatService chatService;
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/chat/enterUser")
    public void enterUser(@Payload ChatDTO request, SimpMessageHeaderAccessor headerAccessor) {
        chatService.enterUser(request, headerAccessor);
    }


    @MessageMapping("/chat/sendMessage")
    public void sendMessage(@Payload ChatDTO request) {
        chatService.sendMessage(request);
    }


    @EventListener
    public void webSocketDisconnectListener(SessionDisconnectEvent event) {
        log.info("DisConnEvent {}", event);

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        Long userId = (Long) headerAccessor.getSessionAttributes().get("userId");
        Long roomId = (Long) headerAccessor.getSessionAttributes().get("roomId");

        log.info("headAccessor {}", headerAccessor);

        User deleteUser = chatService.removeUser(roomId, userId);

        log.info("User Disconnected : " + deleteUser.getEmail());

        ChatDTO chat = ChatDTO.builder()
                .messageType(MessageType.LEAVE)
                .sender(deleteUser.getEmail())
                .message(deleteUser.getEmail() + " 님 퇴장!!")
                .build();

        simpMessageSendingOperations.convertAndSend("/sub/chat/room/" + roomId, chat);
    }

    @GetMapping("/chat/users/{room-id}")
    public List<String> userList(@PathVariable("room-id") Long roomId) {
        return chatService.getUsers(roomId);
    }
}