# movieTicketingSite

**movieTicketingSite는 메가박스를 참고하여 만든 영화예매사이트 프로젝트입니다.**   
Dynamic Web Module 3.1버전을 사용하였습니다.   
root-context.xml의 DataSource bean의 URL property를 본인 DB 설정에 맞게 변경해주세요.   

## 개발환경

### 운영체제

- windows 10

### IDE

- Eclipse 2021-03

### 개발언어

- JAVA (version 1.8)
- CSS
- JS

### 서버

- Apache Tomcat (version 8.5)
- OracleDB

### 프레임워크

- Spring (version 4.3.8)
- MyBatis

### 라이브러리

- JQuery
- JSTL

## 프로젝트 소개

교육기관에서 팀프로젝트를 진행해 만든 프로젝트 입니다.   
최근에 피아니스트, 오만과 편견, 멀홀랜드 드라이브 등 옛날 영화에 관심이 가 주제를 영화와 관련된 영화예매사이트로 정하였습니다.   
총 인원은 2명으로 저는 영화 목록 출력, 영화 정보, 관람평, 예매와 좌석선택, 결제 기능을 맡았습니다.   

### 영화 목록 출력

MovieController.java에서 데이터베이스에 있는 영화정보를 받아와 movieList.jsp에서 출력해 주었습니다.   
(Controller -> Service -> DAO -> DB -> DAO -> Service -> Controller)   
DB에 있는 모든 영화를 가져와 간단한 정보와 함께 출력해 주었습니다.   
- movieList.jsp   
![movieList.jsp](/README_img/movieList.jpg)

### 영화 정보

movieList.jsp에서 선택한 영화의 정보를 자세한 정보를 DB에서 MovieController.java를 통해 가져와 movieDetail.jsp에서 출력해 주었습니다.   
movieDetail.jsp(영화 정보)에서 jsp:include태그를 이용해 줄거리(movieSummary.jsp)와 관람평(movieReview.jsp)를 출력했습니다.
- movieDetail.jsp   
![movieDetail.jsp](/README_img/movieDetail.jpg)

### 영화정보(줄거리)

더보기 버튼 클릭시 전체 줄거리 출력   
JQuery와 CSS를 이용하여 더보기 버튼을 구현했습니다.   
- movieSummary.jsp   
![movieSummary.jsp](/README_img/movieSummary.jpg)

### 영화정보(관람평)

댓글 조회, 입력, 수정, 삭제기능 구현   
각각의 기능은 ajax를 이용하여 값을 넘겨주고 REST API를 이용한 Controller에서 값을 처리해 movieReview.jsp에서 출력해 주었습니다.   
- movieReview.jsp   
![movieReview.jsp](/README_img/movieReview.jpg)

### 예매 정보 입력

영화와 극장을 선택해야 예매가능 시간이 출력되도록 했습니다.   
극장과 시간의 출력은 JQuery와 REST API를 이용하여 구현했습니다.   
- movieTicketing.jsp   
![movieTicketing.jsp](/README_img/movieTicketing.jpg)

### 좌석 선택

좌석은 Controller에서 배열과 2중 for문을 이용하여 해당 극장의 좌석 수만큼 생성해 값을 넘겨주고, JSTL을 이용하여 seatReserve.jsp에서 출력해 주었습니다.   
- seatReserve.jsp   
![seatReserve.jsp](/README_img/seatReserve.jpg)

### 결제

결제는 아임포트 결제 API를 사용하여 구현하였습니다.
- payment.jsp   
![payment.jsp](/README_img/payment.jpg)


## 프로젝트를 진행하면서

### 오류 정리

```
<오류>   
log4j.xml에 빨간줄   
실행에는 문제없지만 미관상 보기좋지 않음   

<해결>   
<!DOCTYPE ~~>태그를   
<!DOCTYPE log4j:configuration SYSTEM "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">   
위 코딩으로 교체   


<오류>   
404에러   
타입 상태 보고   
메시지 요청된 리소스 [/project1/]은(는) 가용하지 않습니다.   
설명 Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나, 그것이 존재하는지를 밝히려 하지 않습니다.   

<해결>   
root-context.xml에서 sqlSessionFactory mapperLocations의 경로가 mappers인데   
src/main/resource의 패키지명을 mappings라고 정의함   
패키지명을 mappings에서 mappers로 바꿔주니 해결됨   


<오류>   
404에러   
타입 상태 보고   
메시지 요청된 리소스 [/project1/]은(는) 가용하지 않습니다.   
설명 Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나, 그것이 존재하는지를 밝히려 하지 않습니다.   

<해결>   
src/main/resource의 mappers패키지안에 mapper.xml파일들에 존재하지 않는 BoardVO클래스를   
사용하여 오류가남   
BoardVO관련 명령어들 삭제 후 해결   


<오류>   
JUnit에러   
Failed to parse mapping resource   

<해결>   
mappers <select> resultType에 MovieVO를 또 BoardVO라고 넣었다   

<오류>   
404에러   
타입 상태 보고   
메시지 파일 [/WEB-INF/views/movie/movieList.jsp]을(를) 찾을 수 없습니다.   
설명 Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나, 그것이 존재하는지를 밝히려 하지 않습니다.   

<해결>   
<title></title>에 값이 없어 실행이 되지 않음   
타이틀에 값을 넣어주니 해결됨   

<문제>   
section #movie_detail_infor로 배경을 설정해주고   
중간지점에 데이터를 입력해주기 위해   
div container position: relative; width: 1280px;로 정의된 div생성   
후에 container의 width 값을 1000px로 바꿔 주었으나 바뀌지 않음   

<문제 원인>   
style태그에 .container이 2개가 지정되어 있음   
후에 container 안에 들어갈 detail_cont_nav와 detail_cont_section의   
container height값이 달라 고치는 도중 중복생성   
하나는 1000px로 되었고 하나는 1280px로 되어있어 문제 발생   

<문제 해결>   
container 하나만 사용하고 싶었지만 height 값 설정 문제로 하나의 container를   
container1로 class값 변경   

<문제>   
div detail_cont_nav와 detail_cont_section이 겹침   

<문제 원인>   
상위 div container을 relative로 주고 많은 하위 div에 absolute를 남발해서   
하위 div 각각이 새로운 포지션을 정의함   

<문제 해결>   
container 안에 detail_cont란 div 생성 후 position을 absolute로 잡아주고   
나머지 하위 div의 absolute를 모두 지워줌   
하위 div에 top,left,bottom,right로 위치 잡아준 것들을 지우고   
margin 값으로 위치 잡아줌   

<문제> & <문제 원인>   
시작되면 1번 li에 미리 on클래스를 주고   
$(this).removeClass('on')과 $(this).addClass('on')으로 나중에 선택된 li style이 바뀌도록 설정했는데   
<li class="cont_nav_li">   
      <a href="movieDetail?movieId=${vo.movieId}&section=movieSummary.jsp">주요 정보</a>   
</li>   
이 부분에서   
href로 movieDetail이 실행될때 2번 li를 클릭해도 처음으로 초기화 돼 1번 li에 on 클래스가 부여되서   
2번 li의 style이 바뀌지 않음   

<문제 해결>   
<li class="cont_nav_li" id="summary">   
Controller에서 if 문으로 section 값에 따라 liIndex값을 변경했으며   
li마다 id를 부여해 스크립트 영역에 if 문을 사용하여 클래스를 추가 제거함   
아래에 코딩 참조   

--MovieController.java--   
int liIndex = 1;   
if(section.equals("movieSummary.jsp")) {   
	LOGGER.info("줄거리 표시");   
	liIndex = 1;   
}else if(section.equals("movieReview.jsp")) {   
	LOGGER.info("관람평 표시");   
	liIndex = 2;   
}else {   
	LOGGER.info("x");   
}   
--movieDetail.jsp--   
if(${liIndex eq '1'}){   
	$('.cont_nav_li').removeClass('on');   
	$('#summary').addClass('on');   
}else if(${liIndex eq '2'}){   
	$('.cont_nav_li').removeClass('on');   
	$('#review').addClass('on');   
}   

---review_mapper, sql---   

<문제>   
댓글입력시 review_id값을 movie_id + count+1로 했는데   
생각해보니 댓글을 삭제하면 count가 줄어들고 그 상태에서 댓글을 입력하면   
pk인 review_id의 값이 중복 돼서 오류가 날것임   

<해결>   
review_seq 시퀀스를 만들어 insert sql의 review_id부분을 movie_id || review_seq.nextval로 바꿈   


<문제>   
JSP내에 JS를 작성하다보니 JSP와 JS의 처리 순서가 다른단 것을 잊고 JS의 변수를 JSP에서 사용하려고 하다 프로젝트가 실행 되지 않는 경우가 잦음   
예시를 하나 들자면 jsp:include 태그의 href값을 변수로 설정해주었는데 JSP태그(스크립트릿, 지시자 등등)을 사용하지 않고 JSTL로만 하려고하니 JS의 변수를 JSP에 적용할 방법을 찾고 있었음   

<해결>   
막힌 부분을 전부 삭제 후 JSP와 JS의 처리 순서를 제대로 인식한 뒤 다시 코드를 짬   
예시 부분은 js가 아닌 controller에서 값을 받아와 처리해줌   
```

### 소감

팀원분과 저 모두 어려웠던 부분이 많았지만 혼자 머리싸매고 구글링하며 해결하거나 서로 도움을 주며 해결하는 등 우여곡절 끝에 서로 생각했던 기능들은 모두 구현하여 프로젝트를 마쳤습니다.   
프로젝트를 진행하며 여태 배워왔던 언어들과 프레임워크의 숙련도를 늘릴 수 있었습니다. 매우 만족하며 헛되게 시간을 보내지 않았다고 생각합니다.   
당장이라도 다른 프로젝트를 진행하여 역량을 높이고 싶다는 생각이 들었고, 저에게 많은 동기부여를 해준 뜻 깊은 시간이었습니다.   
이 프로젝트는 일단락 했지만 아직 고칠 부분이 많고 앞으로도 수정해 나갈것입니다. 또한 구현한 기능들중 디테일한 기능에 욕심이 나면 추가할 예정입니다.   

### 부족했던 점과 아쉬웠던 점

- 처음 설계와 달리 많은 것을 수정했고, 만들어놓고 사용하지 못한 DB Table도 있어 설계에 대한 공부를 더욱 해야겠다고 생각했습니다.   
- 구현한 기능말고도 로그인과 회원가입을 구현하여 암호화와 보안을 공부하고싶었는데 팀프로젝트인 만큼 구현하지 못한게 아쉽습니다.   
  그래서 추후에 토이 프로젝트를 통해 로그인과 회원가입, 유저관리에 중점을 두고 진행하려합니다.   
- 오류 정리를 제때 제때 했어야 했는데 오류를 해결하면 까먹고 다른 기능을 구현하느라 더욱 자세히 오류정리를 하지 못했습니다.   
  추후 토이 프로젝트를 진행할 때는 더 세심하게 오류 작성하도록 노력해야겠습니다.   
- 현재 팀원과 의견차이로 프로젝트를 병합하지 못했고 그러다 보니 예매정보를 DB에 저장하는 기능을 구현하지 못했습니다.   
  팀원과는 꾸준히 커뮤니케이션을 하고 있으니 시간이 될때마다 병합하며 모든 구현을 끝내려고 합니다.   

** 해당 프로젝트는 여전히 진행중에 있습니다.**
