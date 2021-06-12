package goott.spring.project1.persistence;

import java.util.List;

import goott.spring.project1.domain.SeatVO;

public interface SeatDAO {
	public abstract List<SeatVO> select_seat(String theaterId);
	public abstract int update_seat_reserveYn(SeatVO vo);
	public abstract int update_select_seat(SeatVO vo);
}
