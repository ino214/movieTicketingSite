package goott.spring.project1.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goott.spring.project1.domain.ReserveSqlVO;
import goott.spring.project1.persistence.ReviewDAO;
import goott.spring.project1.persistence.ScreenDateDAO;

@Service
public class ScreenDateServiceImple implements ScreenDateService{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(ScreenDateServiceImple.class);
	
	@Autowired
	private ScreenDateDAO dao;
	
	@Override
	public List<ReserveSqlVO> readReserveItem(HashMap<String, String> reserveSqlMap) {
		LOGGER.info("readReserveItem() 호출 : reserveSqlMap = " + reserveSqlMap);
		return dao.selectReserveItem(reserveSqlMap);
	}
	
}
