INSERT INTO board(nameBoard) VALUES
                                 ('자유'),
                                 ('개발'),
                                 ('일상'),
                                 ('사건사고');

INSERT INTO post (id, content, pw, title, idBoard)
VALUES (0, '자바','0000','개발',0),
       (1,'파이썬','1111','공부',1),
       (2,'스프링','2222','에러 파티',2),
       (3,'C','3333','마라탕',3),
       (4,'C++','4444','막창',4),
       (5,'리눅스','5555','연어',5),
       (6,'SQL','6666','대방어',6),
       (7,'오라클','7777','에러 아닌게',7),
       (8,'R','8888','뭐가 있을까...',8),
       (9,'HTML','9999','흑..',9);

DELETE FROM post
WHERE id IS NOT NULL;
