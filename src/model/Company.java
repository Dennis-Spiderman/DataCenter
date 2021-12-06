package model;

public class Company {
	private String nit;
	private String name;
	
	public Company(String nit, String name) {
		this.nit = nit;
		this.name = name;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
