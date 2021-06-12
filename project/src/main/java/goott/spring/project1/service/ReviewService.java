package goott.spring.project1.service;

import java.util.List;

import goott.spring.project1.domain.ReviewVO;

public interface ReviewService {
	public abstract int readCount(String movieId);
	public abstract int createReview(ReviewVO vo);
	public abstract List<ReviewVO> readReview(String movieId);
	public abstract int updateReview(ReviewVO vo);
	public abstract int deleteReview(String reviewId);
}
