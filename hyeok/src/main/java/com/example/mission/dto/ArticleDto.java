package com.example.mission.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private String password;
    private LocalDateTime writtenDate;
}
