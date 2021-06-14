ㄴㄴ<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<div class="movie_review">
		댓글이 총 ${reviewCount }개 있습니다. <br>
		<p>
		댓글 <input type="text" id="write_review"> 
		<button id = "review_add_btn">관람평작성</button>
		</p>
		<c:forEach var="reviewVo" items="${reviewList }">
			<div class="review_item">
				<input type="hidden" id="reviewContent" value="${reviewVo.reviewContent}" />
				<fmt:formatDate value="${reviewVo.reviewDate}"
				pattern="yyyy.MM.dd"
				var="releaseDate"/>
				<p class = "reviewContent_${reviewVo.reviewId}">${reviewVo.reviewContent}</p>
				<p class="review_infor">
					${reviewVo.userId} | ${releaseDate}
					<input type="button" class="review_infor_btn" onclick="reviewUpdate('${reviewVo.reviewId}')" value="수정">
					<input type="button" class="review_infor_btn" onclick="reviewDelete('${reviewVo.reviewId}')" value="삭제">
				</p>
				<div class="review_update_content_${reviewVo.reviewId}" style="display:none;">
					<input type="text" class="update_content_${reviewVo.reviewId}">
					<input type="button" class="review_update_btn" value="수정">
				</div>
			</div>
			<hr>
		</c:forEach>
	</div>
	<script type="text/javascript">
		var movieId = '${vo.movieId}';
		$(document).ready(function(){
			console.log(movieId);
			$('#review_add_btn').click(function(){//공백이나 빈문자열 입력시 return false
				if($.trim($('#write_review').val()) == "" || $('#write_review').val() == null){
					alert('내용을 입력해주세요.');
					$('#write_review').val('');
					return false;
				}
				var userId = 'test';
				var reviewContent = $('#write_review').val();
		        var obj = {
		            'movieId' : movieId,
		            'userId' : userId,
		            'reviewContent' : reviewContent
		        };
		        console.log('객체 호출');
		        console.log(obj);
		        var JSONObj = JSON.stringify(obj);
		        $.ajax({
		           	type : 'post',
		           	url : '../reviews',
		           	headers : {
		            	'Content-Type' : 'application/json', // 데이터를 전송하는 방식을 선언
		            	'X-HTTP-Method-Override' : 'POST'
		           	},
		           	data : JSONObj,
		           	success : function(result, status){
					console.log(result);
		            	console.log(status);
		            	if (result == 1) {
		            		alert('댓글 입력 성공');
		            		location.reload(); // 새로고침
		            		$('#write_review').val(''); // 작성되어 있는 값 초기화
		            	}
		            } 
		         });// end ajax
			});// end review_add_btn.click()
			
			$('#write_review').keypress(function(event){
				if(event.which == 13){
					$('#review_add_btn').click();
					return false;
				}
			});// end write_review.keypress(event)
		});// end document
		
		function reviewUpdate(reviewId){
			console.log(this);
			console.log("댓글 번호 : " + reviewId);
			var updateId = 'review_update_content_';
			updateId += reviewId;
			console.log(updateId);
			if($('.'+updateId).css('display') === 'block'){
				$('.'+updateId).css('display','none');
			}else{
				$('.'+updateId).css('display','block');
			}
			var testtt = $('.reviewContent_'+reviewId).text();
			console.log(testtt);
			//$('.update_content').val($('.'+updateId).children('#reviewContent').val());
			$('.update_content_'+reviewId).val($('.reviewContent_'+reviewId).text());
			$('.review_update_btn').click(function(){
				var reviewContent =  $('.update_content_'+reviewId).val();
				console.log(reviewContent);
				// ajax 요청 데이터 보냄
	        	$.ajax({
					type : 'put', 
					url : '../reviews/' + reviewId,
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'PUT'
					},
					data : JSON.stringify({
						'movieId' : movieId,
						'reviewContent' : reviewContent
					}), 
					success : function(result) {
						if (result == 'success') {
							alert('댓글 수정 성공');
							$('.'+updateId).css('display','none');
							location.reload();
						}
					} // end callback()
	        	}); // end ajax()
			});// end review_update_btn.click()
		}// end reviewUpdate
		
		function reviewDelete(reviewId){
			console.log(this);
			console.log("댓글 번호 : " + reviewId);
			
			// ajax 요청
        	$.ajax({
        		type : 'delete',
        		url : '../reviews/' + reviewId,
        		headers : {
        			'Content-Type' : 'application/json',
					'X-HTTP-Method-Override' : 'DELETE'
        		},
        		data : JSON.stringify({
        			'movieId' : movieId
        		}),
        		success : function(result) {
        			if (result == 'success') {
        				alert('댓글 삭제 성공');
        				location.reload();
        			}
        		}
        	});
		}
	</script>
</body>
</html>