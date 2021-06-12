package goott.spring.project1.domain;

// 관람료
public class PriceVO {
	private int priceId;	   // 관람료 ID
	private int priceTicket;		   // 관람료
	
	public PriceVO() {}

	public PriceVO(int priceId, int priceTicket) {
		super();
		this.priceId = priceId;
		this.priceTicket = priceTicket;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getPriceTicket() {
		return priceTicket;
	}

	public void setPriceTicket(int priceTicket) {
		this.priceTicket = priceTicket;
	}

	@Override
	public String toString() {
		return "PriceVO [priceId=" + priceId + ", priceTicket=" + priceTicket + "]";
	}

	
	
}
