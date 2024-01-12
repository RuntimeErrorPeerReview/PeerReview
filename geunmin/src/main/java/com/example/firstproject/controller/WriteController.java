package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleDto;
import com.example.firstproject.service.ArticleService;
import com.example.firstproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("boards")
public class WriteController {
    private final BoardService boardService;
    private final ArticleService articleService;

    @GetMapping("/{id}/article")
    public String writeForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boardId", id);
        // 게시글 작성시 카테고리 설정
        model.addAttribute("board", boardService.readAllBoard());
        return "article/create";
    }

    @PostMapping("/{id}/postArticle")
    public String write(
            @PathVariable("id") Long board_id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password,
            Model model
    ) {
        model.addAttribute("boardId",board_id);

        Long newId = articleService.create(title, content, password, board_id);
        return String.format("redirect:/article/%d",newId);
    }
}

