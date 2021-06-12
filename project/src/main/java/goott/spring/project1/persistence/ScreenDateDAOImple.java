package goott.spring.project1.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import goott.spring.project1.domain.ReserveSqlVO;

@Component
public class ScreenDateDAOImple implements ScreenDateDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ScreenDateDAOImple.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.ScreenDateMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ReserveSqlVO> selectReserveItem(HashMap<String, String> reserveSqlMap) {
		LOGGER.info("selectReserveItem() 호출 : reserveSqlMap = " + reserveSqlMap);
		return sqlSession.selectList(NAMESPACE + ".select_screenDate_branch", reserveSqlMap);
	}
	
}
