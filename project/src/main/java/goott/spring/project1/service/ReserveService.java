package goott.spring.project1.service;

import java.util.List;

import goott.spring.project1.domain.ReserveVO;

public interface ReserveService {
	public abstract int createReserve(ReserveVO vo);
	public abstract List<ReserveVO> readReserve(String userId);
	public abstract int updateReserve(ReserveVO vo);
}
