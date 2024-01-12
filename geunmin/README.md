#  🍳Overview

### 익명 의견 교환 게시판
사용자들이 자기 자신의 정보를 드러낼 필요 없이 의견을 교환할 수 있는 웹페이지입니다.

단, 작성한 사람이 원한다면 수정, 삭제가 가능합니다!

#  🚩Project
<details>
<summary><strong>SKILL</strong></summary>
<div markdown="1">       

**[Front-end]**  
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" />
<img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">


**[Back-end]**   
<img src="https://img.shields.io/badge/java%2017-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/sqlite-%2307405e.svg?style=for-the-badge&logo=sqlite&logoColor=white">
<img src="https://img.shields.io/badge/spring%20boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/apache%20tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white">
<img src="https://img.shields.io/badge/JPA-005F0F?style=for-the-badge&logo=jpa&logoColor=white">
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white">

**[Tool & Environment]**  
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/IntelliJ%20IDEA-CB5B8D?style=for-the-badge&logo=intellijidea&logoColor=white">
</div>
</details>

<details>
<summary><strong>ERD</strong></summary>
<div markdown="1"> 
  <img width="772" alt="image" src="https://github.com/simidot/Mission_youshin/assets/114278754/0068d3e6-0c6d-4316-92b4-8c24874b2387">
</div>
</details>

<details>
  <summary><strong>간단한 화면 구상</strong></summary>
<div markdown="1">
  <img src="https://github.com/simidot/Mission_youshin/assets/114278754/7dc7dc9f-aebd-431b-94dd-cfa7b0fd937f">
</div>
</details>


#  📍 주요 기능

## 필수 과제
### 1. 게시판 조회 기능
- 사용자는 같은 주제로 작성된 게시글들을 모아 조회할 수 있다.
- 또한 전체 게시글을 위한 전체 게시판이 존재한다.
- 자유/개발/일상/사건사고 게시판이 존재한다.

### 2. 게시글 작성 기능
- 사용자는 하나의 주제에 대한 의견 교환 글을 작성할 수 있다.
- 제목, 내용으로 구성되어 있고, 본인확인을 위한 비밀번호를 작성해야 한다.

### 3. 게시글 조회 및 수정/삭제 기능
- 모든 게시글을 조회할 수 있다.
- 본인확인 비밀번호 입력 후 게시글을 수정/삭제 할 수 있다.


### _아직 제작하지 못한 기능_
### 4. 댓글 기능
- 사용자는 게시글 조회 페이지에서 댓글을 작성할 수 있다.
- 댓글 작성자는 본인확인을 위한 비밀번호도 함께 작성해야 한다.
- 댓글 목록은 조회 페이지에서 확인이 가능하다.
- 댓글 삭제는 본인확인 비밀번호 입력 후 삭제가 가능하다.

## 도전 과제
### 1. 검색 기능
- 사용자는 게시글 목록 페이지와 개별 게시판 조회 페이지에서 검색이 가능하다.
- 검색은 전체/제목/내용을 기준으로 검색이 가능하다.
- 개별 게시판이 선택된 상태에서는 해당 게시판 내에서만 검색이 가능하다.


#  💊 진행 중 발생한 어려움

1. 요구사항에 맞는 엔드포인트를 맞추기는데에 있어 수많은 에러를 발생시켰고, 많은 시간을 소비했다.


2. @PathVariable 이 중복으로 처리해야 하는 과정에서 힘듭을 느꼈다.




# 🖥️ 프로젝트 실행/테스트 방법

#### 실행
1. git clone
2. localhost:8080/boards로 접속하여 테스트한다.
3. 편의를 위해 더미데이터 비밀번호는 모두 **1234**로 설정되어 있다.

#### 테스트
1. localhost:8080/boards에서 전체 게시판 조회
2. 게시글 쓰기 버튼 클릭하여 게시글 작성
3. 작성 후 홈에서 게시글 게시 확인
4. 게시판 목록 중 카테고리 선택 후 게시글 조회
5. 게시글 제목 클릭하여 게시글 상세조회
6. 게시글 수정 비밀번호 입력 후 수정 오른쪽 확인 눌러 수정 (비밀번호 : 1234)
7. 게시글 삭제 비밀번호 입력 후 삭제 오른쪽 확인 눌러 삭제 (비밀번호 : 1234)
