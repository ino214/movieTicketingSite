package goott.spring.project1.domain;

import java.util.Date;

public class ReviewVO {
	private String reviewId;
	private String movieId;
	private String userId;
	private String reviewContent;
	private Date reviewDate;
	
	public ReviewVO() {}
	
	public ReviewVO(String reviewId, String movieId, String userId, String reviewContent, Date reviewDate) {
		this.reviewId = reviewId;
		this.movieId = movieId;
		this.userId = userId;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}
	
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [reviewId=" + reviewId + ", movieId=" + movieId + ", userId=" + userId + ", reviewContent="
				+ reviewContent + ", reviewDate=" + reviewDate + "]";
	}
	
	
}
