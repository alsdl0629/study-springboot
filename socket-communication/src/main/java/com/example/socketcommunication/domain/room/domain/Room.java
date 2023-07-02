package com.example.socketcommunication.domain.room.domain;

import com.example.socketcommunication.domain.chat.domain.Chat;
import com.example.socketcommunication.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String createUser;

    @OneToMany(mappedBy = "room")
    private Map<Long, User> users;

    @OneToMany(mappedBy = "room")
    private List<Chat> chats;

    public void plusUser(User user) {
        this.users.put(user.getId(), user);
    }

    public User removeUser(User user) {
        return this.users.remove(user.getId());
    }
}
