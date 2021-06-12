package goott.spring.project1.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import goott.spring.project1.domain.ReserveVO;

@Component
public class ReserveDAOImple implements ReserveDAO{
	private static Logger LOGGER = 
			LoggerFactory.getLogger(ReserveDAOImple.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.ReserveMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert_reserve(ReserveVO vo) {
		LOGGER.info("insert_reserve() 호출 vo : " + vo);
		return sqlSession.insert(NAMESPACE + ".insert_reserve", vo);
	}

	@Override
	public List<ReserveVO> select_reserve(String userId) {
		LOGGER.info("select_reserve() 호출 userId : " + userId);
		return sqlSession.selectList(NAMESPACE + ".select_reserve", userId);
	}

	@Override
	public int update_reserve(ReserveVO vo) {
		LOGGER.info("update_reserve() 호출 vo : " + vo);
		return sqlSession.update(NAMESPACE + ".update_reserve", vo);
	}
	

}
