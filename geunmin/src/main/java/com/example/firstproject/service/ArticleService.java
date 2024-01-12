package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleDto;
import com.example.firstproject.dto.BoardDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Board;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;

    // 게시글 작성
    public Long create (
            String title,
            String content,
            String password,
            Long boardId

    ) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setPassword(password);
        //board 선택
        Optional<Board> optionalBoard
                = boardRepository.findById(boardId);

        //article에 board 할당
        article.setBoard(optionalBoard.orElse(null));

        Article savedArticle = articleRepository.save(article);
        return savedArticle.getId();
    }

    // 게시글 조회
    public ArticleDto read (Long id) {
        Article article = articleRepository.findById(id).orElseThrow();

        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setContent(article.getContent());
        articleDto.setPassword(article.getPassword());

        return articleDto;
    }

    // 게시글 수정
    public void update (Long id, ArticleDto articleDto) {
        Article article = articleRepository.findById(id).orElseThrow();

        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setPassword(articleDto.getPassword());

        articleRepository.save(article);
    }

    // 게시글 삭제
    public void delete(Long id) {
        articleRepository.delete(articleRepository.findById(id).orElseThrow());

    }

    //비밀번호 검증
    public boolean checkingPassword(Long id, String password) {
        Article article = articleRepository.findById(id).orElseThrow();
        return article.getPassword().equals(password);
    }

    //articleid로 boardid 가져오기
    public Board findBoardByArticle(Long id) {
        return boardRepository.findBoardByArticleListId(id);
    }




}
