package goott.spring.project1;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import goott.spring.project1.domain.ReserveSqlVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ScreenDateSqlSessionTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(ScreenDateSqlSessionTest.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.ScreenDateMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testSelect() {
		LOGGER.info("testSelect() 호출");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("branchId", "GGN");
		map.put("screenDate", "2021/05/07");
		map.put("movieId", "M_001");
		LOGGER.info(map+"");
		List<ReserveSqlVO> list = sqlSession.selectList(NAMESPACE + ".select_screenDate_branch", map);
		LOGGER.info("list size: " + list.size());
		LOGGER.info("list : " + list);
	}
}
