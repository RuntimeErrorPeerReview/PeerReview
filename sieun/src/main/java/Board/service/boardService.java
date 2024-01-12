package Board.service;


import Board.entity.board;
import Board.repository.boardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class boardService {
    private final boardRepo boardRepository;
    public void article(boardDto boardDto) {
        board boardEntity = board.toSaveEntity(boardDto);
        boardRepository.save(boardEntity);
    }

    @Transactional
    public List<boardDto> findAll() {
        List<board> boardEntityList= boardRepository.findAll();
        List<boardDto> boardDtoList = new ArrayList<>();
        for (boardEntity boardEntity : boardEntityList) {
            boardDtoList.add(boardDto.toBoardDto(boardEntity));
        }
        return boardDtoList;
    }


    public boardDto finById(Long id) {
        Optional<board> optionalBoardEntity = boardRepo.findById(id);
        if (optionalBoardEntity.isPresent()) {
            board boardEntity = optionalBoardEntity.get();
            BoardDto boardDto = boardDto.toBoardDto(boardEntity);
            return boardDto;
        } else {
            return null;
        }
    }

    public boardDto update(boardDto boardDto) {
        board boardEntity = boardEntity.toUpdateEntity(boardDto);
        boardRepository.save(boardEntity);
        return finById(boardDto.getId());
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
