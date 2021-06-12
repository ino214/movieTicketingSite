<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<style>
.container {position: relative; width: 1000px; margin: 0 auto;}
.movie_item{
	display: inline-block; 
	float:left;
	margin: 0; 
	padding-right: 18px;
}
.movie_item, .poster img, .infor a{
	width: 230px;
}
.poster{position: relative;}
.poster img{display: block;}
.infor{line-height: 60%;}
.infor a{
	text-decoration: none;
	display: block; 
	float: left;
	border-radius: 10px;
	margin-right: 2%; 
	margin-bottom: 2%;
	padding: 15px 0; 
	text-align: center; 
	background: #7F38EC; 
	color: white; 
	font-size: 18px;
}
.infor a:hover{
	background-color: #5d14cc;
}
.age0{ 
	display: inline-block;
	border-radius: 10px;
	height: 20px;
	width: 20px;
	background-color: lime;
	color:white;
}
.age12{
	display: inline-block;
	border-radius: 10px;
	height: 20px;
	width: 20px;
	background-color: #3e9cef;
	color:white;
}
.age15{
	display: inline-block;
	border-radius: 10px;
	height: 20px;
	width: 20px;
	background-color: yellow;
	color:white;
}
.age19{
	display: inline-block;
	border-radius: 10px;
	height: 20px;
	width: 20px;
	background-color: red;
	color:white;
}
.long_char{
	font-size: 12px;
}
</style>
<title>전체 영화</title>
</head>
<body>
	<h1>전체 영화</h1>
	<section>
		<div class="container">
				<div class="movie">
					<div class="movie_title">
						<h1></h1>
					</div> <!-- end movie_title -->
					<div class="movie_list">
						<c:forEach var="vo" items="${list }">
							<div class="movie_item">
								<div class="poster">
									<a href="movieDetail?movieId=${vo.movieId}&section=movieSummary.jsp">
									<img alt="${vo.movieName}" src="../resources/img/${vo.movieId}.jpg">
									</a>
								</div> <!-- end poster -->
								<div class="infor">
									<p><span class="age${vo.ageLimit}"></span> ${vo.movieName}</p>
									<p>${vo.movieGenre}</p> 
									<fmt:formatDate value="${vo.releaseDate}"
									pattern="yyyy.MM.dd"
									var="releaseDate"/>
									<p class="long_char">누적 관객 ${vo.audCount}명 | 개봉일 ${releaseDate}</p>
									<a href="#">예매</a>
								</div> <!-- end infor -->
							</div> <!-- end movie_item -->
						</c:forEach>
					</div> <!-- end movie_list -->
				</div> <!-- end movie -->
		</div> <!-- end container -->
	</section>
</body>
</html>