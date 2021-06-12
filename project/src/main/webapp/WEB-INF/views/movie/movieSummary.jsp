<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="section_summary">
		<div class="summary_txt">
			<h1>${vo.movieSummaryTitle}</h1>
			${vo.movieSummaryContent}
		</div> <!-- end summary_txt -->
		<div class="summary_btn">
			<input type="button" class="more_btn" value="더보기">
		</div> <!-- end summary_btn -->
		<div class="summary_detail">
			<fmt:formatDate value="${vo.releaseDate}"
			pattern="yyyy.MM.dd"
			var="releaseDate"/>
			<p>
				장르:${vo.movieGenre}/${vo.screenTime}분 
				<span>|</span> 등급:${vo.ageLimit}세이상관람가 
				<span>|</span> 개봉일:${releaseDate}<br>
				출연진:${vo.movieCast}
			<p>
		</div>
	</div> <!-- end section_summary -->
	
	
	<script type="text/javascript">
	$('.more_btn').click(function(){
		if($('.more_btn').hasClass('extends')){
			$('.summary_txt').removeClass('extends');
			$(this).removeClass('extends');
			$(this).val('더보기');
		}else{
			$('.summary_txt').addClass('extends');
			$(this).addClass('extends');
			$(this).val('닫기');
		}
	});// end more_btn.click()
	</script>
</body>
</html>