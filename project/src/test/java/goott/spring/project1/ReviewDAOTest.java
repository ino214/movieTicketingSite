package goott.spring.project1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import goott.spring.project1.domain.ReviewVO;
import goott.spring.project1.persistence.ReviewDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ReviewDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(ReviewDAOTest.class);
	
	@Autowired
	private ReviewDAO dao;
	
	@Test
	public void testDAO() {
//		testSelect();
		testInsert();
	}

	private void testInsert() {
		String movieId = "M_001";
		ReviewVO vo = new ReviewVO(null, "M_001", "test", "아니 이게뭐야", null);
		vo.setReviewId(movieId + "_");
		LOGGER.info("testInsert() 호출 vo : " + vo.toString());
		int result = dao.insert_review(vo);
		LOGGER.info(result + "");
	}

	private void testSelect() {
		LOGGER.info("testSelect() 호출");
		int count = dao.select_reivew_count("m_001");
		LOGGER.info(count+"");
	}

}
