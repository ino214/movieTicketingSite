package goott.spring.project1.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import goott.spring.project1.domain.ReviewVO;

@Component
public class ReviewDAOImple implements ReviewDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ReviewDAOImple.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.ReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int select_reivew_count(String movieId) {
		LOGGER.info("select_review_count() 호출");
		return sqlSession.selectOne(NAMESPACE + ".select_review_count", movieId);
	}

	@Override
	public int insert_review(ReviewVO vo) {
		LOGGER.info("insert_review() 호출 vo : " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert_review", vo);
	}

	@Override
	public List<ReviewVO> select_review(String movieId) {
		LOGGER.info("select_review() 호출 movieId : " + movieId);
		return sqlSession.selectList(NAMESPACE + ".select_review", movieId);
	}

	@Override
	public int update_review(ReviewVO vo) {
		LOGGER.info("update_review() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update_review", vo);
	}

	@Override
	public int delete_review(String reviewId) {
		LOGGER.info("delete_review() 호출 : reviewId = " + reviewId);
		return sqlSession.delete(NAMESPACE + ".delete_review", reviewId);
	}
	
	

}
