<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<style>
div{
	margin: 0;
	padding: 0;
}
a{
	cursor: pointer;
	display: block;
	text-decoration: none;
	color: #000000;
}
.reserve_container{
	position: relative; 
	width: 1100px; 
	height: auto;
	margin: 0 auto;
}
.reserve_main{
	width: 100%;
	height: 540px;
	border: 1px solid #efefef;
	border-top: 1px solid #000000;
}
.reserve_main_title ul, li{
	display: inline-block;
	margin: 0;
	padding: 0;
}
.reserve_main_title ul{
	width: 100%;
}
.reserve_main_title li{
	width: 12.5%;
	float: left;
}
.reserve_main_title a{
	text-align: center;
	height: 40px;
	border-bottom: 1px solid #efefef;
	line-height: 40px;
}
.reserve_main_title a:hover {
	border-bottom: 2px solid #5d14cc;
}
.reserve_main_title .date_on a{
	border-bottom: 2px solid #5d14cc;
	background-color: #efefef;
}
.reserve_main_section{
	display: inline-block;
	float: left;
	height: 500px;
	margin-top: -2px;
	border-left: 1px solid #efefef;
	margin: 0 auto;
}
.reserve_main_content{
	margin: 10px 20px;
}
.reserve_movie_list{
	padding: 0px 5px;
	padding-top: 20px;
}
.reserve_movie_item a{
	height: 20px;
}
.reserve_movie_item p{
	line-height: 20px;
}
.reserve_movie_list .movie_on a{
	background-color: #efefef;
}
.age0, .age12, .age15, .age19{ 
	display: inline-block;
	border-radius: 10px;
	height: 15px;
	width: 15px;
	color:white;
}
.age0{
	background-color: lime;
}
.age12{
	background-color: #3e9cef;
}
.age15{
	background-color: yellow;
}
.age19{
	background-color: red;
}
.reserve_branch_city_list, .reserve_branch_list{
	padding-top: 20px;
	diplay: inline-block;
	float: left;
	height: 430px;
	width: 140px;
}
.reserve_branch_city_list{
	border-right: 1px solid #efefef;
	padding-left: 10px;
}

.reserve_branch_list{
	padding-right: 10px;
}
.
.reserve_branch_city, .reserve_branch_item{
	width: 140px;
	height: 20px;
}
.reserve_branch_city a, .reserve_branch_item a{
	width: 140px;
	height: 20px;
}
.reserve_branch_list .on a, .reserve_branch_city_list .on a{
	background-color: #efefef;
}
.reserve_branch_item{
	height: 20px;
}
.reserve_date_list{
	padding-top: 20px;
}

.reserve_date_item{
	height: 66px;
}
.reserve_date_item a{
	height: 66px;
}
.reserve_date_item a:hover{
	background-color: #efefef;
}

.reserve_date_item_cont{
	display: inline-block;
	float: left;
	height: 40px;
	margin: 10px 0;
}
.reserve_date_item_cont p{
	 margin: 0;
	 padding: 0;
	 font-size: 20px;
}
</style>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>예매</title>
</head>
<body>
	<div class="reserve_container">
		<h2>예매</h2>
		<div class="reserve_main">
			<div class="reserve_main_title">
				<ul>
					<c:forEach var="dateString" items="${dateList }" varStatus="status">
						<fmt:parseDate var="date" value="${dateString}" pattern="yyyy/MM/dd" />
						<fmt:formatDate value="${date}"
									pattern="dd"
									var="dateItem"/>
						<c:if test="${status.first}">
						<li class="reserve_date date_on" id="${dateString}"><a>${dateItem}</a></li>
						</c:if>
						<c:if test="${not status.first}">
						<li class="reserve_date" id="${dateString}"><a>${dateItem}</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="reserve_main_section" style="width: 268px;">
				<div class="reserve_main_content">
					<strong>영화</strong>
					<div class="reserve_movie_list">
						<c:forEach var="movieVo" items="${movieList }">
							<c:choose>
							<c:when test="${movieVo.movieId eq param.movieId}">
								<div class="reserve_movie_item movie_on">
									<a><span class="age${movieVo.ageLimit}"></span> ${movieVo.movieName}</a>
									<input type="hidden" class="movieId" value="${movieVo.movieId}">
									<input type="hidden" class="movieName" value="${movieVo.movieName}">
								</div>
							</c:when>
							<c:otherwise>	
								<div class="reserve_movie_item">
									<a><span class="age${movieVo.ageLimit}"></span> ${movieVo.movieName}</a>
									<input type="hidden" class="movieId" value="${movieVo.movieId}">
									<input type="hidden" class="movieName" value="${movieVo.movieName}">
								</div>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="reserve_main_section" style="width: 348px;">
				<div class="reserve_main_content">
					<strong>극장</strong><br>
					<div class="reserve_branch_city_list">
						<div class="reserve_branch_city" id="서울"><a>서울</a></div>
						<div class="reserve_branch_city" id="경기"><a>경기</a></div>
						<div class="reserve_branch_city" id="인천"><a>인천</a></div>
					</div>
					<div class="reserve_branch_list"></div>
				</div>
			</div>
			<div class="reserve_main_section" style="width: 478px;">
				<div class="reserve_main_content">
					<strong>시간</strong>
						<div class="reserve_date_list"></div><!-- end reserve_date_list -->
				</div><!-- end reserve_main_content -->
			</div><!-- end reserve_main_section -->
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$('.reserve_date').click(function(){
			console.log(this);
			$('.reserve_date').removeClass('date_on');
			$(this).addClass('date_on');
		});
		$('.reserve_movie_item').click(function(){
			console.log(this);
			$('.reserve_movie_item').removeClass('movie_on');
			$(this).addClass('movie_on');
		});
		$('.reserve_branch_city').click(function(){
			console.log(this);
			$('.reserve_branch_city').removeClass('on');
			$(this).addClass('on');
			
			var branchCity = $(this).attr('id');
			console.log(branchCity);
			
			reserveCity(branchCity);
		});
		
		function reserveCity(branchCity){
			console.log(this);
			console.log('선택 지역 : ' + branchCity);
			$.getJSON(
				'../reserves/' + branchCity,
				function(jsonData){
					console.log(jsonData);
					var list = '';
					$(jsonData).each(function(){
						console.log(this);
						list += '<div class="reserve_branch_item" id=' + this.branchName + '>'
							+ '<a>' + this.branchName + '</a><br>'
							+ '<input class="branchId" type="hidden" value=' + this.branchId + '>'
							+ '</div>';
					});// end each()
					$('.reserve_branch_list').html(list);
				} // end callback()
	    	); // end getJSON()
		}// end reserveCity()
		
		$('.reserve_branch_list').on('click', '.reserve_branch_item', function() {
		//$('.reserve_branch_item').click(function(){
			console.log(this);
			$('.reserve_branch_item').removeClass('on');
			$(this).addClass('on');
			
			var branchName = $(this).attr('id');
			var branchId = $(this).find('.branchId').val();
			console.log(branchId);
			console.log(branchName);
			
			reserveDate(branchId);
		});// end reserve_branch_item.click()
		
		function reserveDate(branchId){
			var branchName = $('.reserve_branch_list').find('.on').attr('id');
			var screenDate = $('.date_on').attr('id');
			var movieId = $('.movie_on').find('.movieId').val();
			var movieName = $('.movie_on').find('.movieName').val();
			console.log('지점 아이디 : ' + branchId);
			console.log(screenDate);
			console.log(movieId);
			console.log(movieName);
			console.log(branchName);
			$.getJSON(
					'../reserves/date/' + branchId + '?screenDate=' + screenDate + '&movieId=' + movieId,
					function(jsonData){
						console.log(jsonData);
						var list = '';
						$(jsonData).each(function(){
							console.log(this);
							list += '<div class="reserve_date_item">'
								+ '<a href="../seat/seatReserve">' 
								+ '<div class="reserve_date_item_cont" style="width: 60px; font-size: 12px;"><p>' + this.startTime.substring(11,16) + '</p>~' 
								+ this.endTime.substring(11,16) + '</div>'
								+ '<div class="reserve_date_item_cont" style="width: 279px; padding-left: 10px;">' + movieName + '</div>'
								+ '<div class="reserve_date_item_cont" style="width: 89px;"><span style="font-size: 12px; float: right;">' + branchName 
								+ '<br>' + this.theaterId.substring(5, 6) + '관<br>'
								+ this.seatCount + '/' + this.screenIn + '</p></div>'
								+ '</a>'
								+ '</div>';
						});// end each()
						$('.reserve_date_list').html(list);
					} // end callback()
			   	); // end getJSON()
		}// end reserveDate()
	});
</script>
</html>