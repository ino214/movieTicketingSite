package goott.spring.project1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goott.spring.project1.domain.ReserveSqlVO;
import goott.spring.project1.persistence.SeatDAO;

@Service
public class SeatServiceImple implements SeatService{
	private static Logger LOGGER =
			LoggerFactory.getLogger(SeatServiceImple.class);
	
	@Autowired
	private SeatDAO dao;
	
	@Override
	public List<Integer> readSeat(ReserveSqlVO vo) {
		LOGGER.info("readSeat() 호출 : vo = " + vo);
		return dao.select_seat(vo);
	}
}
