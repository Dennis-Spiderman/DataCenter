package model;

import java.util.ArrayList;
import java.util.List;

public class MiniRoom {
	private boolean available;
	private int corridor; //Row
	private boolean window;
	private int column;
	private double price;
	@SuppressWarnings("unused")
	private List<Server> servers;
	private String windowStr;
	@SuppressWarnings("unused")
	private Company company;
	@SuppressWarnings("unused")
	private ProjectInvestigation projectInvestigation;
	private boolean light;
	private String lightStr;
	private String rentDate;
	
	private final double BASE_PRICE = 500000;
	
	public MiniRoom(int corridor, int column) {
		this.corridor = corridor;
		this.column = column;
		available = true;
		light = false;
		setLightStr();
		servers = new ArrayList<Server>();
		setWindow();
		calculatePrice();
		setWindowStr();
	}
	
	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public void setLigth(boolean light) {
		this.light = light;
		
		setLightStr();
	}
	
	public void setLightStr() {
		if(light) {
			lightStr = "(*)";
		}else {
			lightStr = "( )";
		}
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getCorridor() {
		return corridor;
	}

	public void setCorridor(int corridor) {
		this.corridor = corridor;
	}

	public boolean isWindow() {
		return window;
	}
	
	public void setWindow() {
		if(corridor == 0 || corridor == 7) {
			window = true;
		}else if(column == 0 || column == 49) {
			window = true;
		}else {
			window = false;
		}
	}
	
	public void setWindowStr() {
		if(window) {
			windowStr = "Sí";
		}else {
			windowStr = "No";
		}
	}
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void calculatePrice() {
		price = BASE_PRICE;
		
		if(window) {
			price -= BASE_PRICE*0.1;
		}else {
			price = BASE_PRICE;
		}
		
		if(corridor == 6) {
			price -= (BASE_PRICE*0.15);
		}else if(corridor >= 1 && corridor <= 5) {
			price += (BASE_PRICE*0.25);
		}
	}
	
	public void rent(Company c, String d, ArrayList<Server> s){
		company = c;
		rentDate = d;
		servers = s;
		available = false;
		
		priceWithServers();
	}
	
	public void rentByProject(ProjectInvestigation p, String d, ArrayList<Server> s) {
		projectInvestigation = p;
		rentDate = d;		
		servers = s;
		available = false;
		
		priceWithServers();
	}
	
	public void priceWithServers() {
		if(servers.size() < 4) {
			price += BASE_PRICE*0.15;
		}
	}
	
	public void cancelRent() {
		company = null;
		projectInvestigation = null;
		rentDate = null;
		servers = null;
		available = true;
		
		calculatePrice();
	}
	
	@Override
	public String toString() {
		return "\n------------------------------\nCorredor: " + (corridor + 1) + "\nVentana: " + windowStr + "\nColumna: " + (column + 1) + "\nAlquiler: " + price + 
				"\n------------------------------";
	}
	
	public String getMap() {
		return	"[ " + lightStr + " ]";
	}
	
}
