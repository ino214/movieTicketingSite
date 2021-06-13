<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<style>
.seat_container{
	position: relative; 
	width: 1100px; 
	height: auto;
	margin: 0 auto;
}
.seat_list_container{
	display: inline-block;
	float: left;
	position: relative;
	width: 750px;
	height: 550px;
	border: 1px solid #000000;
}
.seat_movie_container{
	display: inline-block;
	position: relative;
	width: 288px;
	height: 535px;
	margin-left: 20px;
	border-radius: 10px;
	background-color: #333333;
	padding: 0 20px;
	padding-top: 15px;
}
.seat_list_title{
	position: absolute;
	width: 100%;
	height: 30px;
	background-color: #efefef;
}
.seat_list{
	position: absolute;
	left: 50%;
	top: 25%;
	margin-left: -150px;
}
.seat_list .on input[type=button]{
	background-color: #000000;
}

.seat_item{
	display: inline-block;
	float: left;
}
.seat_item input[type=button]{
	display: inline;
	width: 20px;
	height: 20px;
	font-size: 12px;
	float: left;
	background-color: #888888;
	color: #ffffff;
	text-align: center;
	border: 1px solid #000000;
	padding: 0;
	margin: 0;
	margin-right: 1px;
	cursor: pointer;
}
.seat_item input[type=button]:hover{
	background-color: #000000;
}
.seat_movie_title{
	height: 28px;
	border-bottom: 1px solid #666666;
}
.seat_movie_title p{
	color: #ffffff;
	margin: 0;
	padding: 0;
	font-size: 16px;
}
.seat_movie_sec{
	padding-top: 10px;
	padding-bottom: 10px;
	border-bottom: 1px solid #666666;
}
.seat_movie_sec_cont{
	width: 200px;
	display: inline-block;
	float: left;
	color: #888888;
}
.seat_movie_sec img{
	width: 70px;
	height: 100px;
}
.seat_movie_price{
	color: #ffffff;
}
#total_price{
	display: inline;
}
.seat_movie_footer{
	bottom: 0px;
}
</style>
<html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="seat_container">
		<h1>예약</h1>
		<div class="seat_list_container">
			<div class="seat_list_title">
				관람인원 선택 : <select id="customer_count">
					<option value=1 >1명</option>
					<option value=2 >2명</option>
					<option value=3 >3명</option>
					<option value=4 >4명</option>
				</select>
			</div>
			<div class="seat_list">
				screenIn
				<c:forEach var="numList" items="${seatNumList}" varStatus="status">
					<c:if test="${status.index % 15 eq 0}"><br></c:if> 
					<div class="seat_item"><input type="button" value="${numList}"></div>
				</c:forEach>
			</div>
		</div>
		<div class="seat_movie_container">
			<div class="seat_movie_title">
				<p>${movieName}</p>
			</div>
			<div class="seat_movie_sec">
				<div class="seat_movie_sec_cont">
					${branchName} <br>
					${fn:substring(reserveSqlVo.theaterId, 5, 6)}관 <br>
					${reserveSqlVo.startTime} <br> <br>
					${fn:substring(reserveSqlVo.startTime, 11, 16)} ~ ${fn:substring(reserveSqlVo.endTime, 11, 16)}
				</div>
				<div class="seat_movie_sec_post">
					<img alt="${movieName} 포스터" src="../resources/img/${reserveSqlVo.movieId}.jpg">
				</div>
				
			</div>
			<div class="seat_movie_price">
				최종결제금액 : <div id="total_price">0</div>원
			</div>
			<div class="seat_movie_footer">
				<input type="button" id="footer_btn1" value="이전">
				<input type="button" onClick="location.href='payment?movieName=${movieName}'" id="footer_btn2" value="다음" disabled="disabled">
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		var price = 0;
		$('.seat_item').click(function(){
			var on = $('.on').length;
			var sele = $('#customer_count option:selected').val();
			var hasOn = $(this).hasClass('on')
			
			console.log(on);
			console.log(sele);
			console.log(hasOn);
			
			if(on < sele && hasOn == false){
				$(this).addClass('on');
				price += 8000;
				if(on == sele-1){
					$('#footer_btn2').attr('disabled', false);
				}
			}else if(on >= sele && hasOn == false){
				alert('모든 좌석을 선택하셨습니다');
			}
			if(hasOn == true){
				$(this).removeClass('on');
				price -= 8000;
				if(on == sele){
					$('#footer_btn2').attr('disabled', true);
				}
			}
			console.log(on);
			$("#total_price").text(price);
		});
		
		$('#customer_count').change(function(){
			var on = $('.on').length;
			var onMinus = on - 1;
			console.log('onMinus :' + onMinus);
			console.log('on :' + on);
			console.log($(this).val());
			if($(this).val() < on){
				alert('관람인원보다 선택된 좌석이 많습니다.');
				$('#customer_count').val(on).prop('selected', true);
			}
			if($(this).val() > on){
				$('#footer_btn2').attr('disabled', true);
			}
		});
	});
	
</script>
</html>