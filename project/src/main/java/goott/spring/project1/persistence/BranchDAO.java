package goott.spring.project1.persistence;

import java.util.List;

import goott.spring.project1.domain.BranchVO;

public interface BranchDAO {
	public abstract List<BranchVO> select_branch(String branchCity);
}
