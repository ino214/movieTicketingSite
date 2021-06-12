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

import goott.spring.project1.domain.BranchVO;
import goott.spring.project1.domain.ReserveSqlVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BranchSqlSessionTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(BranchSqlSessionTest.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.BranchMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testSelect() {
		LOGGER.info("testSelect() 호출");
		List<BranchVO> list = sqlSession.selectList(NAMESPACE + ".select_branch");
		LOGGER.info(""+list);
	}
}
