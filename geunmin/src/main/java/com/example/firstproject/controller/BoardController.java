package com.example.firstproject.controller;

import com.example.firstproject.service.ArticleService;
import com.example.firstproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("boards")
public class BoardController {

    private final BoardService boardService;
    private final ArticleService articleService;


    @GetMapping
    public String readAllBoard(Model model){
        model.addAttribute("boards", boardService.readAllBoard());
        return "board/home";
    }


    @GetMapping("{boardId}")
    public String readBoard(@PathVariable("boardId") Long id, Model model) {
        model.addAttribute("board", boardService.read(id));
        model.addAttribute("articles", boardService.readByBoardId(id));
        return "board/board";
    }

    // "전체 게시판"
    @GetMapping("/entire-board")
    public String entireBoard(Model model) {
        model.addAttribute("articles", boardService.readAll());
        return "board/entireBoard";
    }

}
