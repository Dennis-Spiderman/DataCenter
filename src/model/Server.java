package model;

public class Server {
	private double memory;//En gb
	private int processors; 
	private String processorBrand;
	private int ram;//En gb.
	private int disk;
	private String disksCapacity;//En teras.
	
	public Server(double memory, int processors, String processorBrand, int ram, int disk, String disksCapacity) {
		super();
		this.memory = memory;
		this.processors = processors;
		this.processorBrand = processorBrand;
		this.ram = ram;
		this.disk = disk;
		this.disksCapacity = disksCapacity;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public int getProcessors() {
		return processors;
	}

	public void setProcessors(int processors) {
		this.processors = processors;
	}

	public String getProcessorBrand() {
		return processorBrand;
	}

	public void setProcessorBrand(String processorBrand) {
		this.processorBrand = processorBrand;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getDisk() {
		return disk;
	}

	public void setDisk(int disk) {
		this.disk = disk;
	}

	public String getDisksCapacity() {
		return disksCapacity;
	}

	public void setDisksCapacity(String disksCapacity) {
		this.disksCapacity = disksCapacity;
	}
}
