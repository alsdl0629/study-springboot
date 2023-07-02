package com.example.socketcommunication.domain.room.presentation;

import com.example.socketcommunication.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/rooms")
@RestController
public class RoomController {

    private final RoomService roomService;


    @GetMapping
    public List<GetRoomsResponse> getRooms() {
        return roomService.getRooms();
    }

    @PostMapping
    public void createRoom(@RequestParam String name) {
        roomService.createRoom(name);
    }

}
