package com.example.socketcommunication.domain.room.service;

import com.example.socketcommunication.domain.room.domain.Room;
import com.example.socketcommunication.domain.room.domain.RoomRepository;
import com.example.socketcommunication.domain.room.presentation.GetRoomsResponse;
import com.example.socketcommunication.domain.user.domain.User;
import com.example.socketcommunication.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final UserFacade userFacade;

    public void createRoom(String name) {
        User currentUser = userFacade.getCurrentUser();
        roomRepository.save(Room.builder()
                .name(name)
                .createUser(currentUser.getEmail())
                .build());
    }

    public List<GetRoomsResponse> getRooms() {
        List<Room> rooms = roomRepository.findAll();

        return rooms.stream()
                .map(room -> new GetRoomsResponse(room.getName(), room.getUsers().size()))
                .toList();
    }
}
