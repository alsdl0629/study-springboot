package com.example.login.damain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 36)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 15)
    private String password;

    @NotNull
    @Size(max = 10)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String email, String password, String name, Authority authority) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.authority = authority;
    }

}
