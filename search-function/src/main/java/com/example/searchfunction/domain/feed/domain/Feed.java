package com.example.searchfunction.domain.feed.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Builder
    public Feed(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
