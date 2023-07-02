package com.example.socketcommunication.domain.user.domain;

import com.example.socketcommunication.domain.room.domain.Room;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public void enterRoom(Room room) {
        this.room = room;
    }
}
