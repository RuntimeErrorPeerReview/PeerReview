package Board.repository;

import Board.entity.board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface boardRepo extends JpaRepository<board, Long> {
}