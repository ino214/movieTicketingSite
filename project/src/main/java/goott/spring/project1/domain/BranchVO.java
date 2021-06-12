package goott.spring.project1.domain;

// 吏��젏
public class BranchVO {
	private String branchId;   // 지점 ID
	private String branchName; // 지점명
	private String branchCity; // 지점 도시
	
	public BranchVO() {}

	public BranchVO(String branchId, String branchName, String branchCity) {
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchCity = branchCity;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	@Override
	public String toString() {
		return "BranchVO [branchId=" + branchId + ", branchName=" + branchName + ", branchCity=" + branchCity + "]";
	}
	
	
}
