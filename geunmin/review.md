# 리뷰

## Controller
```java
@Controller
@RequiredArgsConstructor
@RequestMapping("boards")
public class BoardController {

    //...
}
```

```java
@Controller
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleController {
    //...
```
```java
@Controller
@RequiredArgsConstructor
@RequestMapping("boards")
public class WriteController {
    //...
}
```

`@RequestMapping`을 통해 URL 값들이 공통적인 메서들를 모아놓았다. 그렇지만 게시글을 작성하는 메서드가 있지만, 'WriteController'를 만들어 따로 분리를 해놓았다. 
게시글을 작성할 때 /boards/{:boardId}/article/ 엔드포인트로 맞추기 위해서 이다.


## Entity
```java
@Getter 
@Setter
@RequiredArgsConstructor
public class BoardDto {
    private Long id;
    private String boardName;
    private List<ArticleDto> articles = new ArrayList<>();

    public BoardDto(Long id, String boardName) {
        this.id = id;
        this.boardName = boardName;
    }
}
```
Entity 클래스에서 table을 생성하였으며, 게시판에 있는 글들을 조회하기 위해 List<ArticleDto>를 사용했다.

## Repository

```java
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query
    List<Article> findAllByOrderByIdDesc();
    @Query
    List<Article> findByBoardIdOrderByIdDesc(Long boardId);
}
```
List<Article> findAllByOrderByIdDesc();는 "전체게시판"를 조회할 때 모든 게시물들을 id의 역순으로 출력하기
위해 작성하였다.
List<Article> findByBoardIdOrderByIdDesc(Long boardId);는 하나의 게시판을 조회할 때 해당 게시판에 속한
게시물들을 id의 역순으로 조회하기 위해 작성하였다.



