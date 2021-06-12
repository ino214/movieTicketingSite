package goott.spring.project1.service;

import java.util.List;

import goott.spring.project1.domain.BranchVO;

public interface BranchService {
	public abstract List<BranchVO> readBranch(String branchCity);
}
