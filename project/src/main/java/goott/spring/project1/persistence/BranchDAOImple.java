package goott.spring.project1.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import goott.spring.project1.domain.BranchVO;

@Component
public class BranchDAOImple implements BranchDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BranchDAOImple.class);
	
	private static final String NAMESPACE = 
			"goott.spring.project1.BranchMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BranchVO> select_branch(String branchCity) {
		LOGGER.info("select_branch 호출 : branchCity = " + branchCity);
		return sqlSession.selectList(NAMESPACE + ".select_branch", branchCity);
	}
}
