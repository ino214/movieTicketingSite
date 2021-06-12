package goott.spring.project1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import goott.spring.project1.domain.ReserveVO;
import goott.spring.project1.persistence.ReserveDAO;

@Service
public class reserveServiceImple implements ReserveService{
	private static Logger LOGGER =
			LoggerFactory.getLogger(reserveServiceImple.class);
	
	private ReserveDAO dao;
	
	@Override
	public int createReserve(ReserveVO vo) {
		LOGGER.info("createReserve() 호출 vo : " + vo);
		return dao.insert_reserve(vo);
	}

	@Override
	public List<ReserveVO> readReserve(String userId) {
		LOGGER.info("readReserve() 호출 userId : " + userId);
		return dao.select_reserve(userId);
	}

	@Override
	public int updateReserve(ReserveVO vo) {
		LOGGER.info("updateReserve() 호출 vo : " + vo);
		return dao.update_reserve(vo);
	}
	

}
