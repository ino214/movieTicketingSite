package goott.spring.project1.service;

import java.util.List;

import goott.spring.project1.domain.ReserveSqlVO;

public interface SeatService {
	public abstract List<Integer> readSeat(ReserveSqlVO vo);
}
