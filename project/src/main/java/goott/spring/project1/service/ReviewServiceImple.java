package goott.spring.project1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goott.spring.project1.domain.ReviewVO;
import goott.spring.project1.persistence.ReviewDAO;

@Service
public class ReviewServiceImple implements ReviewService{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(ReviewServiceImple.class);
	
	@Autowired
	private ReviewDAO dao;
	
	@Override
	public int readCount(String movieId) {
		LOGGER.info("readCount() 호출 : movieId = " + movieId);
		return dao.select_reivew_count(movieId);
	}

	@Override
	public int createReview(ReviewVO vo) {
		vo.setReviewId(vo.getMovieId() + "_");
		LOGGER.info("createReview() 호출 : vo = " + vo.toString());
		return dao.insert_review(vo);
	}

	@Override
	public List<ReviewVO> readReview(String movieId) {
		LOGGER.info("readReview() 호출 : movieId = " + movieId);
		return dao.select_review(movieId);
	}

	@Override
	public int updateReview(ReviewVO vo) {
		LOGGER.info("updateReview() 호출 : vo = " + vo.toString());
		return dao.update_review(vo);
	}

	@Override
	public int deleteReview(String reviewId) {
		LOGGER.info("deleteReview() 호출 : reviewId = " + reviewId);
		return dao.delete_review(reviewId);
	}
	
	
}
