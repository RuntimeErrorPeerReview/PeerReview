package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Board;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class BoardDto {
    private Long id;
    private String boardName;
    private List<ArticleDto> articles = new ArrayList<>();

    public BoardDto(Long id, String boardName) {
        this.id = id;
        this.boardName = boardName;
    }
}


