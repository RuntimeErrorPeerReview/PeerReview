INSERT INTO board (board_name)
VALUES
    ('자유 게시판'),
    ('개발 게시판'),
    ('일상 게시판'),
    ('사건 사고 게시판');

INSERT INTO article (id, content, password, title, board_id)
VALUES
    (1, '안녕하세요. 반갑습니다!!', '1234', '첫인사',1),
    (2, '어렵습니다', '1234', 'Spring에 대하여',2),
    (3, '힘냅시다!!', '1234', '화이팅!',1),
    (4, '돈까스. 맛있었다.', '1234', '어제 저녁',3),
    (5, '댓글창 끝내기', '1234', '오늘 할일',3),
    (6, '댓글 기능 제작 실패', '1234', '[속보]댓글창 못끝내...',4),
    (7, '갑작스런 무수한 에러 발생해', '1234', '[단독]delete 메서드 작동안해...',4);





DELETE FROM article
WHERE id IS NOT NULL;


