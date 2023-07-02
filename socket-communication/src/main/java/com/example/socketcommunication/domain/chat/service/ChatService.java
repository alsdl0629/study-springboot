package com.example.socketcommunication.domain.chat.service;

import com.example.socketcommunication.domain.chat.domain.ChatRepository;
import com.example.socketcommunication.domain.chat.presentation.ChatDTO;
import com.example.socketcommunication.domain.room.domain.Room;
import com.example.socketcommunication.domain.room.domain.RoomRepository;
import com.example.socketcommunication.domain.user.domain.User;
import com.example.socketcommunication.domain.user.domain.repository.UserRepository;
import com.example.socketcommunication.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final RoomRepository roomRepository;
    private final UserFacade userFacade;
    private final SimpMessageSendingOperations simpMessageSendingOperations;
    private final UserRepository userRepository;

    public void enterUser(ChatDTO request, SimpMessageHeaderAccessor headerAccessor) {
        User currentUser = userFacade.getCurrentUser();

        Room room = roomRepository.findById(request.getRoomId()).get();
        room.plusUser(currentUser);
        currentUser.enterRoom(room);

        headerAccessor.getSessionAttributes().put("userId", currentUser.getId());
        headerAccessor.getSessionAttributes().put("roomId", room.getId());

        simpMessageSendingOperations.convertAndSend("/sub/chat/room/" + room.getId(), request);
    }

    public void sendMessage(ChatDTO request) {
        log.info("CHAT {}", request);
        Room room = roomRepository.findById(request.getRoomId()).get();
        simpMessageSendingOperations.convertAndSend("/sub/chat/room/" + room.getId(), request);
    }

    public User removeUser(Long roomId, Long userId) {
        Room room = roomRepository.findById(roomId).get();
        User user = userRepository.findById(userId).get();
        return room.removeUser(user);
    }

    public List<String> getUsers(Long roomId) {
        Room room = roomRepository.findById(roomId).get();

        Map<Long, User> users = room.getUsers();

        return new ArrayList<>(users.values().stream().map(value -> value.getEmail()).toList());
    }
}
