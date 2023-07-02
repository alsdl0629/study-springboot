package com.example.socketcommunication.domain.room.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetRoomsResponse {

    private String name;

    private int userCount;
}
