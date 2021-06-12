package goott.spring.project1;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import goott.spring.project1.domain.MovieVO;
import goott.spring.project1.persistence.MovieDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class MovieDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(MovieDAOTest.class);
	
	@Autowired
	private MovieDAO dao;
	
	@Test
	public void testDAO() {
		testSelect();
	}

	private void testSelect() {
		List<MovieVO> list = dao.select();
		LOGGER.info(list.size() + "");
		for(MovieVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}

}
