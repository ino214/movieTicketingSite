package goott.spring.project1.domain;

// 좌석
public class SeatVO {
	private String seatId; // 좌석 ID
	private String theaterId; // 상영관 ID
	private int seatNum; // 좌석 No
	private char seatReserveYn; // 예약가능_Yes or No
	private String reserveId; // 예매 id
	private String startTime;
	public SeatVO() {}

	public SeatVO(String seatId, String theaterId, int seatNum, char seatReserveYn, String reserveId, String startTime) {
		super();
		this.seatId = seatId;
		this.theaterId = theaterId;
		this.seatNum = seatNum;
		this.seatReserveYn = seatReserveYn;
		this.reserveId = reserveId;
		this.startTime = startTime;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public char getSeatReserveYn() {
		return seatReserveYn;
	}

	public void setSeatReserveYn(char seatReserveYn) {
		this.seatReserveYn = seatReserveYn;
	}

	public String getReserveId() {
		return reserveId;
	}

	public void setReserveId(String reserveId) {
		this.reserveId = reserveId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "SeatVO [seatId=" + seatId + ", theaterId=" + theaterId + ", seatNum=" + seatNum + ", seatReserveYn="
				+ seatReserveYn + ", reserveId=" + reserveId + ", startTime=" + startTime + "]";
	}

	
	
}
