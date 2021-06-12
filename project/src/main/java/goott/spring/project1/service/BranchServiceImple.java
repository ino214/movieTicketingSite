package goott.spring.project1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goott.spring.project1.domain.BranchVO;
import goott.spring.project1.persistence.BranchDAO;

@Service
public class BranchServiceImple implements BranchService{
	private static Logger LOGGER =
			LoggerFactory.getLogger(BranchServiceImple.class);
	
	@Autowired
	private BranchDAO dao;
	
	@Override
	public List<BranchVO> readBranch(String branchCity) {
		LOGGER.info("readBranch() 호출 : branchCity = " + branchCity);
		return dao.select_branch(branchCity);
	}

}
