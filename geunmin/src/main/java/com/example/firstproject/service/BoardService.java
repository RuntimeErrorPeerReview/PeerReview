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

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;

    // 모든 게시판 출력
    public List<BoardDto> readAllBoard() {
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board: boardRepository.findAll()) {
            BoardDto boardDto = new BoardDto(board.getId(), board.getBoardName());
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    // 해당 게시판 정보 조회
    public BoardDto read(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();

        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setBoardName(board.getBoardName());

        return boardDto;
    }

    // 모든 게시글 조회
    // "전체 게시판"에 사용
    public List<ArticleDto> readAll() {
        List<ArticleDto> articleDtoList = new ArrayList<>();

        // 최신순으로 정렬
        List<Article> articles = articleRepository.findAllByOrderByIdDesc();

        for (Article article : articles) {
            ArticleDto dto = new ArticleDto();
            dto.setId(article.getId());
            dto.setTitle(article.getTitle());
            dto.setContent(article.getContent());
            dto.setPassword(article.getPassword());

            articleDtoList.add(dto);
        }
        return articleDtoList;
    }

    // 해당 Board에 속한 Article 조회
    // 하나의 게시판 조회에 사용
    public List<ArticleDto> readByBoardId(Long boardId) {
        List<ArticleDto> articleDtoList = new ArrayList<>();

        // 최신순으로 정렬
        List<Article> articles = articleRepository.findByBoardIdOrderByIdDesc(boardId);

        for (Article article : articles) {
            ArticleDto dto = new ArticleDto();
            dto.setId(article.getId());
            dto.setTitle(article.getTitle());
            dto.setContent(article.getContent());
            dto.setPassword(article.getPassword());

            articleDtoList.add(dto);
        }
        return articleDtoList;
    }
}
