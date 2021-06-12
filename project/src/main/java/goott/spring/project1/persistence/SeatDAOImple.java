package goott.spring.project1.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import goott.spring.project1.domain.SeatVO;

@Component
public class SeatDAOImple implements SeatDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(SeatDAOImple.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.SeatMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<SeatVO> select_seat(String theaterId) {
		LOGGER.info("select_seat 호출 : theaterId = " + theaterId);
		return sqlSession.selectList(NAMESPACE + ".select_seat", theaterId);
	}

	@Override
	public int update_seat_reserveYn(SeatVO vo) {
		LOGGER.info("update_seat_reserveYn 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update_seat_reserveYn", vo);
	}

	@Override
	public int update_select_seat(SeatVO vo) {
		LOGGER.info("update_select_seat 호출 : vo = " + vo);
		return sqlSession.update(NAMESPACE + ".update_select_seat", vo);
	}

}
