package Board.entity;

import Board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "board_Table")

public class board {
    public static board toSaveEntity(boardDto boardDto) {
        @Id // pk
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column
        private String boardPass;

        @Column
        private String boardTitle;

        @Column(length = 500)
        private String boardContents;

        @Column
        private int boardHits;

        public static board toSaveEntity(BoardDto boardDto) {
            board board = new board();
            board.setBoardPass(boardDto.getBoardPass());
            board.setBoardTitle(boardDto.getBoardTitle());
            board.setBoardContents(boardDto.getBoardContents());
            return board;
        }
        public static board toUpdateEntity(BoardDto boardDto) {
            board boardEntity = new board();
            boardEntity.setId(boardDto.getId());
            boardEntity.setBoardPass(boardDto.getBoardPass());
            boardEntity.setBoardTitle(boardDto.getBoardTitle());
            boardEntity.setBoardContents(boardDto.getBoardContents());
            return boardEntity;
    }
}
