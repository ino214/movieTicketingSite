package goott.spring.project1.persistence;

import java.util.List;

import goott.spring.project1.domain.ReviewVO;

public interface ReviewDAO {
	public abstract int select_reivew_count(String movieId);
	public abstract int insert_review(ReviewVO vo);
	public abstract List<ReviewVO> select_review(String movieId);
	public abstract int update_review(ReviewVO vo);
	public abstract int delete_review(String reviewId);
}
