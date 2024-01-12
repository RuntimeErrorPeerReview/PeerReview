package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String boardName;

    @OneToMany(mappedBy = "board")
    private List<Article> articleList;

    public Board() {
    }

    public Board(String boardName) {
        this.boardName = boardName;
    }





}
