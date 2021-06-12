package goott.spring.project1.domain;

import java.util.Date;

// 예매정보
public class ReserveVO {
	private int reserveId;  // 예매 ID
	private String movieId; // 영화 ID
	private String userId;  // 회원 ID
	private String priceId; // 관람료 ID
	private int seatId;  // 좌석 ID
	private int reserveTotPrice;  // 총 결제 비용
	private Date reserveViewDay; // 관람일
	private Date reserveBuyDay; // 예매일
	private char reserveYnc; // 예매/취소/ 변경
	
	public ReserveVO() {}

	public ReserveVO(int reserveId, String movieId, String userId, String priceId, int seatId, int reserveTotPrice,
			Date reserveViewDay, Date reserveBuyDay, char reserveYnc) {
		super();
		this.reserveId = reserveId;
		this.movieId = movieId;
		this.userId = userId;
		this.priceId = priceId;
		this.seatId = seatId;
		this.reserveTotPrice = reserveTotPrice;
		this.reserveViewDay = reserveViewDay;
		this.reserveBuyDay = reserveBuyDay;
		this.reserveYnc = reserveYnc;
	}

	public int getReserveId() {
		return reserveId;
	}	

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
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

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getReserveTotPrice() {
		return reserveTotPrice;
	}

	public void setReserveTotPrice(int reserveTotPrice) {
		this.reserveTotPrice = reserveTotPrice;
	}

	public Date getReserveViewDay() {
		return reserveViewDay;
	}

	public void setReserveViewDay(Date reserveViewDay) {
		this.reserveViewDay = reserveViewDay;
	}

	public Date getReserveBuyDay() {
		return reserveBuyDay;
	}

	public void setReserveBuyDay(Date reserveBuyDay) {
		this.reserveBuyDay = reserveBuyDay;
	}

	public char getReserveYnc() {
		return reserveYnc;
	}

	public void setReserveYnc(char reserveYnc) {
		this.reserveYnc = reserveYnc;
	}

	@Override
	public String toString() {
		return "ReserveVO [reserveId=" + reserveId + ", movieId=" + movieId + ", userId=" + userId + ", priceId="
				+ priceId + ", seatId=" + seatId + ", reserveTotPrice=" + reserveTotPrice + ", reserveViewDay="
				+ reserveViewDay + ", reserveBuyDay=" + reserveBuyDay + ", reserveYnc=" + reserveYnc + "]";
	}

	
}
