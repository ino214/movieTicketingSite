package goott.spring.project1.persistence;

import java.util.List;

import goott.spring.project1.domain.ReserveVO;

public interface ReserveDAO {
	public abstract int insert_reserve(ReserveVO vo);
	public abstract List<ReserveVO> select_reserve(String userId);
	public abstract int update_reserve(ReserveVO vo);
}
