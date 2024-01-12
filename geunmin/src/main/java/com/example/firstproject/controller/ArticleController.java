package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleDto;
import com.example.firstproject.dto.BoardDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Board;
import com.example.firstproject.service.ArticleService;
import com.example.firstproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleController {
    private final ArticleService articleService;
    private final BoardService boardService;

    // #.게시물 조회
    @GetMapping("{id}")
    public String readArticle(@PathVariable("id") Long id, Model model) {
        ArticleDto article = articleService.read(id);
        model.addAttribute("article", article);
        return "article/read";
    }

    // #.게시물 수정
    @GetMapping("/{id}/update")
    public String checkUpdatePasswordForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("article", articleService.read(id));
        return "article/updateCheck";
    }
    // @.비밀번호 확인
    @PostMapping("/{id}/verify-update-password")
    public String verifyUpdatePassword(
            @PathVariable("id") Long id,
            @RequestParam("password") String password
    ) {
        if (articleService.checkingPassword(id,password)) {
            // 일치 했을 시 수정폼으로 이동
            return String.format("redirect:/article/%d/update-form",id);
        } else {
            // 틀렸을 시 에러 페이지로 이동
            return "redirect:/article/{id}/password-incorrect";
        }
    }
    // @.수정폼
    @GetMapping("/{id}/update-form")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("article", articleService.read(id));
        return "article/update";
    }

    @PostMapping("/{id}/update-article")
    public String updateArticle(
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password
    ) {
        articleService.update(id,new ArticleDto(title,content,password));
        return String.format("redirect:/article/%d", id);
    }


    // #.게시물 삭제
    @GetMapping("/{id}/delete")
    public String checkDeletePasswordForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("article", articleService.read(id));
        return "article/deleteCheck";
    }
    // @.비밀번호 확인
    @PostMapping("/{id}/verify-delete-password")
    public String verifyDeletePassword(
            @PathVariable("id") Long id,
            @RequestParam("password") String password
    ) {
        if (articleService.checkingPassword(id,password)) {
            // 일치 했을 시 삭제폼으로 이동
            return String.format("redirect:/article/%d/delete-form",id);
        } else {
            // 틀렸을 시 에러 페이지로 이동
            return "redirect:/article/{id}/password-incorrect";
        }
    }
    // @.삭제폼
    @GetMapping("/{id}/delete-form")
    public String deleteForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("article", articleService.read(id));
        return "article/delete";
    }

    @PostMapping("/{id}/delete-article")
    public String deleteArticle(@PathVariable("id") Long articleId, RedirectAttributes redirectAttributes) {

        articleService.delete(articleId);
        Board foundBoard = articleService.findBoardByArticle(articleId);

        redirectAttributes.addAttribute("boardId",foundBoard.getId());

        return "redirect:/boards/boardId";
    }

//    @GetMapping("/{id}/delete")
//    public String deleteForm(@PathVariable("id")Long id, Model model) {
//        model.addAttribute("article",articleService.read(id));
//        return "article/delete";
//    }
//    @PostMapping("/{id}/delete-article")
//    public String deleteArticle(
//            @PathVariable("id")Long id,
//            @RequestParam("password") String password
//            ){
//
//        articleService.delete(id,password);
//
//        return String.format("redirect:/article/%d",id);
//    }


    // #. 비밀번호가 틀렸을 시
    @GetMapping("/{id}/password-incorrect")
    public String incorrect(@PathVariable("id")Long id, Model model) {
        model.addAttribute("article",articleService.read(id));
        return "article/incorrect";
    }
    @PostMapping("/{id}/update-article/incorrect")
    public String incorrectError(@PathVariable("id")Long id, Model model) {
        model.addAttribute("article",articleService.read(id));
        return "redirect:/article/{id}";
    }



}

