package goott.spring.project1.service;

import java.util.HashMap;
import java.util.List;

import goott.spring.project1.domain.ReserveSqlVO;

public interface ScreenDateService {
	public abstract List<ReserveSqlVO> readReserveItem(HashMap<String, String> reserveSqlMap);
}
