package com.model;

public class BranchVo {
	private String branchName;
	private int branchId;
	private String HOD;
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getHOD() {
		return HOD;
	}
	public void setHOD(String hOD) {
		HOD = hOD;
	}

	@Override
	public String toString() {
		return branchName;
	}
}
