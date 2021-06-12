package goott.spring.project1.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import goott.spring.project1.domain.MovieVO;

@Component
public class MovieDAOImple implements MovieDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MovieDAOImple.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.MovieMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MovieVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public MovieVO select(String movieId) {
		LOGGER.info("select() 호출 : movieId = " + movieId);
		return sqlSession.selectOne(NAMESPACE + ".select_movieId", movieId);
	}
	
}
