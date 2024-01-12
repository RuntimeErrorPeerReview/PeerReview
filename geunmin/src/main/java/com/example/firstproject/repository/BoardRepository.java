package com.example.firstproject.repository;

import com.example.firstproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findBoardByArticleListId(Long id);
}
