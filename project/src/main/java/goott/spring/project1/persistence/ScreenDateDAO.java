package goott.spring.project1.persistence;

import java.util.HashMap;
import java.util.List;

import goott.spring.project1.domain.ReserveSqlVO;

public interface ScreenDateDAO {
	public abstract List<ReserveSqlVO> selectReserveItem(HashMap<String, String> reserveSqlMap);
}
