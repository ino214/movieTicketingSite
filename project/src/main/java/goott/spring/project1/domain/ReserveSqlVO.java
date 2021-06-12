package goott.spring.project1.domain;

import java.util.Date;

public class ReserveSqlVO {
	private String movieId;
	private String startTime;
	private String endTime;
	private String branchId;
	private String theaterId;
	private int seatCount;
	private int screenIn;
	
	public ReserveSqlVO() {}

	public ReserveSqlVO(String movieId, String startTime, String endTime, String branchId, String theaterId, int seatCount, int screenIn) {
		this.movieId = movieId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.branchId = branchId;
		this.theaterId = theaterId;
		this.seatCount = seatCount;
		this.screenIn = screenIn;
	}
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getScreenIn() {
		return screenIn;
	}

	public void setScreenIn(int screenIn) {
		this.screenIn = screenIn;
	}

	@Override
	public String toString() {
		return "ReserveSqlVO [movieId=" + movieId + ", startTime=" + startTime + ", endTime=" + endTime + ", branchId="
				+ branchId + ", theaterId=" + theaterId + ", seatCount=" + seatCount + ", screenIn=" + screenIn + "]";
	}

	

	
	
	
}
