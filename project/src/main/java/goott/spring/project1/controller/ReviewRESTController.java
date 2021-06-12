package goott.spring.project1.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import goott.spring.project1.domain.ReviewVO;
import goott.spring.project1.service.ReviewService;


@RestController
@RequestMapping(value = "/reviews")
public class ReviewRESTController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewRESTController.class);
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<Integer> createReview(@RequestBody ReviewVO vo) {
		LOGGER.info("createReview 호출 : vo = " + vo.toString());
		int result; // 리턴타입
		try {
			result = reviewService.createReview(vo);
			return new ResponseEntity<Integer>(result, HttpStatus.OK); // 결과데이터와 HTTP 상태코드 같이 보내기
			// 추가 설명 - 단순히 데이터가 있는지 없는지뿐만 아니라 제대로 값이 왔는지를  ResponseEntity<>로 확인
		
		} catch (Exception e) {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
	}// end createReview()
	
	@PutMapping("/{reviewId}") // PUT : 댓글 수정
	public ResponseEntity<String> updateReview(
			@PathVariable("reviewId") String reviewId,
			@RequestBody ReviewVO vo
			) {
			vo.setReviewId(reviewId);
			LOGGER.info("updateReview 호출 : movieId = " + vo.getMovieId());
			int result = reviewService.updateReview(vo);
			ResponseEntity<String> entity = null;
			if (result == 1) {
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			}
			return entity;
	}
	
	@DeleteMapping("/{reviewId}") // DELETE : 댓글 삭제
	public ResponseEntity<String> deleteReview(
			@PathVariable("reviewId") String reviewId,
			@RequestBody ReviewVO vo ) {
		LOGGER.info("deleteReview 호출 : reviewId = " + vo.getReviewId());
		
		try {
			reviewService.deleteReview(reviewId);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}
}
