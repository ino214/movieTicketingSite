<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
#movie_detail_infor{
	position: relative;
	display: block;
	height: 500px;
	z-index: 1;
	padding: 0;
	margin: 0;
	padding-left: 10px;
}
#movie_detail_infor::after{
	position: absolute;
	display: block;
	height: 100%;
	width: 100%;
	content: "";
	background-image:
		linear-gradient(to right, 
		black 25%,
		rgba(0,0,0,0.5)  49.5% 50%,
		black 75%),
		url("../resources/img/${vo.movieId}.jpg");
	background-repeat: no-repeat;
	background-position:top;
	top: 0;
	left: 0;
	z-index: -1;
}

body{margin: 0px;}
#detail_header{
	height: 50px;
}
.span_c{
	font-size: 20px;
	text-align: center;
	margin: 0 auto;
}
.span_c span{
	margin-right: 40px;
	display: inline-block;
	height: 50px;
	width: 50px;
	line-height: 50px;
}
#movie_detail_content{
}
.container{
	position: relative;
	margin: 0 auto;
	width: 1100px;
	height: 500px;
}
.title{
	position: absolute;
	color: white;
	top: 40px;
	left: 10px;
	font-size: 40px;
	margin: 0;
	padding: 0;
	line-height: 80%;
}
.post{
	position: absolute;
	right: 10px;
	margin: 40px 10px 0px auto;
}
.post img, .post a{
	width: 260px;
	border-radius: 10px;
}
.post a{
	text-decoration: none;
	display: block;
	height: 40px;
	background-color: #7F38EC; 
	text-align: center;
	line-height: 40px;
	color: white;
}
.post a:hover{
	background-color: #5d14cc;
}
.detail_infor{
	position: absolute;
	display: inline-block;
	float: left;
	color: #d1d1d1;
	line-height: 60%;
	bottom: 40px;
	left: 10px;
}
.rating_avg, .aud_count{
	display: block;
	float: left;
	margin-right: 20px;
}
.rating_avg h1, .aud_count h1{
	color: white;
	display: inline;
}


.detail_cont{
	position: absolute;
	width: 100%;
}

.detail_cont_nav{
	clear: both;
}

.detail_cont_section{
	clear: both;
}

ul, li{
	display: inline-block;
	margin: 0;
	padding: 0;
}
.cont_nav_ul{
	margin-top: 10px;
	width: 100%;
}
.cont_nav_li{
	width: 33.33%;
}
.cont_nav_li a{
	text-decoration: none;
	text-align: center;
	display: block;
	height: 40px;
	background-color: white;
	border: 1px solid #efefef;
	border-bottom: 1px solid #5d14cc;
	line-height: 40px;
}

.on a{
	border: 1px solid #5d14cc;
	border-bottom: none;
}


.container1 {
	position: relative; 
	width: 1100px; 
	height: auto;
	margin: 0 auto;
	background-color: #111111;
}

.summary_txt{
	overflow: hidden;
	height: 135px;
}
.summary_txt.extends{
	height:auto;
}

.more_btn{
	border: none;
	background-color: white;
	border-bottom: 1px solid #d2d2d2;
	width: 100%;
	height: 30px;
}
.more_btn:hover{
	border-bottom: 1px solid #000000;
}

.detail_cont_section{
	position: absolute;
	width: 100%;
}

.movie_review{
	padding: 0px 10px;
	margin-bottom: 5px;
	width: 99%;
}
.movie_review p{
	margin: 0;
}
.movie_review hr{
	margin: 0 auto;
	width: 99%;
	border: none;
	border-bottom: 0.5px solid #BBBBBB;
}
.movie_reivew input{
	margin: 0;
}
.movie_review button{
	margin: 0;
	border: none;
}

.review_item{
	display: block;
	margin: 5px 0;
}

.review_infor{
	color: #666666;
	font-size: 13px;
	
}

.review_infor_btn{
	margin: 0;
	border: none;
	background-color: transparent;
	cursor:pointer;
	
}
</style>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- <link rel="stylesheet" href="../resources/css/review.css"/> -->
<title>${vo.movieName}</title>
</head>
<body>
	<header id="detail_header">
		<div class="span_c">
			<span><a href="movieList" style="text-decoration: none;"><strong>영화</strong></a></span>
			<!-- 예매 -->
			<span><a href="../reserve/movieTicketing?movieId=${vo.movieId}" style="text-decoration: none;"><strong>예매</strong></a></span>
		</div>
	</header>
	<section id="movie_detail_infor">
		<div class="container">
			<div class="title">
				${vo.movieName}
				<p style="font-size: 25px; line-height: 0;">${vo.movieEngTitle}</p>
			</div><!-- end title -->
			<div class="post">
				<img alt="${vo.movieName} 포스트" src="../resources/img/${vo.movieId}.jpg">
				<br> <!-- 예매 -->
				<a href="../reserve/movieTicketing?movieId=${vo.movieId}"><strong>예매</strong></a>
			</div> <!-- end post -->
			<div class= "detail_infor">
				<!-- <div class="rating_avg">
					<p>실관람 평점</p>
					<h1>10.0</h1>
				</div> -->
				<div class="aud_count">
					<p>누적관객수</p>
					<h1>${vo.audCount}</h1>명
				</div>
			</div> <!-- end detail_infor -->
		</div> <!-- end container -->
	</section> <!-- end section movie_detail_title -->
	
	<section id="movie_detail_content">
		<div class="container1">
			<div class="detail_cont">
				<div class="detail_cont_nav">
					<ul class="cont_nav_ul">
					<li class="cont_nav_li" id="summary"><a href="movieDetail?movieId=${vo.movieId}&section=movieSummary.jsp">주요 정보</a></li><!-- 여백 없애기
					 --><li class="cont_nav_li" id="review"><a href="movieDetail?movieId=${vo.movieId}&section=movieReview.jsp">관람평</a></li><!-- 여백 없애기
					 --><li class="cont_nav_li"><a href="#">트레일러</a></li>
					</ul>
				</div>
				<div class="detail_cont_section">
					<jsp:include page="${param.section}"/>
				</div> <!-- end detail_cont_section -->
			</div> <!-- detail_cont -->
		</div> <!-- end container1 -->
	</section> <!-- end section movie_detail_content -->
</body>
<script type="text/javascript">
	$(document).ready(function(){
		if(${liIndex eq '1'}){
			$('.cont_nav_li').removeClass('on');
			$('#summary').addClass('on');
		}else if(${liIndex eq '2'}){
			$('.cont_nav_li').removeClass('on');
			$('#review').addClass('on');
		}
	}); // end document
</script>
</html>