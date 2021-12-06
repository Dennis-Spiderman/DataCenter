package model;

public class ProjectInvestigation {
	private int registerNumber;

	@SuppressWarnings("unused")
	private final Company ICESI = new Company("890.316.745-5","Icesi");

	public ProjectInvestigation(int registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}
}
