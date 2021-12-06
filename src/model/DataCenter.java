package model;

import java.util.ArrayList;

public class DataCenter {
	private MiniRoom[][] minirooms;
	
	private int ROWS = 8;
	private int COLUMNS = 50;
	
	public DataCenter() {
		minirooms = new MiniRoom[ROWS][COLUMNS];
		createMinirooms();
	}
	
	public void createMinirooms() {
		for (int i = 0; i < minirooms.length; i++) {
			for (int j = 0; j < minirooms[i].length; j++) {
				MiniRoom mr = new MiniRoom(i, j);
				minirooms[i][j] = mr;
			}
		}
	}
	
	public String seeAvailableMinirooms() {
		String availableMR = "";
		
		for (int i = 0; i < minirooms.length; i++) {
			for (int j = 0; j < minirooms[i].length; j++) {
				if(minirooms[i][j].isAvailable()) {
					availableMR += minirooms[i][j].toString();
				}
			}
		}
		
		return availableMR;
	}
	
	public String seeAllMinirooms() {
		String map = "";
		
		for (int i = 0; i < minirooms.length; i++) {
			for (int j = 0; j < minirooms[i].length; j++) {
				map += minirooms[i][j].getMap();
			}
			map += "\n";
		}
		
		return map;
	}
	
	public void rentMiniroomByCompany(String nit, String name, String rentDate, int row, int column, double[] serversCache, int[] serversProcessors, String[] serversProcessorsBrands, int[] serversRam, int[] serversDisks, String[] serversDisksCapacity) {
		if(minirooms[(row-1)][(column-1)].isAvailable()) {
			Company comp = new Company(nit, name);
			ArrayList<Server> servers = new ArrayList<>();
			
			for (int i = 0; i < serversDisksCapacity.length; i++) {
				Server s = new Server(serversCache[i], serversProcessors[i], serversProcessorsBrands[i], serversRam[i], serversDisks[i], serversDisksCapacity[i]);
				servers.add(s);
			}
			
			minirooms[(row-1)][(column-1)].rent(comp, rentDate, servers);
			
			System.out.println("El minicuarto ha sido alquilado correctamente.");
		}else {
			System.out.println("El minicuarto seleccionado no se encuentra disponible.");
		}
	}
	
	public void rentMiniroomByProject(String rentDate, int row, int column, int registerNumber, double[] serversCache, int[] serversProcessors, String[] serversProcessorsBrands, int[] serversRam, int[] serversDisks, String[] serversDisksCapacity) {
		if(minirooms[(row-1)][(column-1)].isAvailable()) {
			ProjectInvestigation project = new ProjectInvestigation(registerNumber);
			ArrayList<Server> servers = new ArrayList<>();
			
			for (int i = 0; i < serversDisksCapacity.length; i++) {
				Server s = new Server(serversCache[i], serversProcessors[i], serversProcessorsBrands[i], serversRam[i], serversDisks[i], serversDisksCapacity[i]);
				servers.add(s);
			}
			
			minirooms[(row-1)][(column-1)].rentByProject(project, rentDate, servers);
			
			System.out.println("El minicuarto ha sido alquilado correctamente.");
		}else {
			System.out.println("El minicuarto seleccionado no se encuentra disponible.");
		}
	}
	
	public void turnOnAllMinirooms() {
		for (int i = 0; i < minirooms.length; i++) {
			for (int j = 0; j < minirooms[i].length; j++) {
				minirooms[i][j].setLigth(true);
			}
		}
	}
	
	public void cancelMiniroomRent(int row, int column) {
		if(!minirooms[(row-1)][(column-1)].isAvailable()) {
			minirooms[(row-1)][(column-1)].cancelRent();
			
			System.out.println("El alquiler del minicuarto del corredor " + row + ", en la columna " + column + ", ha sido cancelado.");
		}else {
			System.out.println("El minicuarto selccionado no ha sido alquilado aún.");
		}
	}
	
	public void turnOffL() {
		for (int i = 0; i < minirooms[0].length; i++) {
			minirooms[0][i].setLigth(false);
		}
		
		for (int i = 0; i < minirooms.length; i++) {
			minirooms[i][0].setLigth(false);
		}
	}
	
	public void turnOffH() {
		for (int i = 0; i < minirooms.length; i++) {
			if((i+1)%2 != 0) {
				for (int j = 0; j < minirooms[i].length; j++) {
					minirooms[i][j].setLigth(false);
				}
			}
		}
	}
	
	public void turnOffO() {
		for (int i = 0; i < minirooms.length; i++) {
			for (int j = 0; j < minirooms[i].length; j++) {
				if(minirooms[i][j].isWindow()) {
					minirooms[i][j].setLigth(false);
				}
			}
		}
	}
	
	public void turnOffM(int column) {
		for (int i = 0; i < minirooms.length; i++) {
			minirooms[i][(column-1)].setLigth(false);
		}
	}
	
	public void turnOffP(int corridor) {
		for (int i = 0; i < minirooms[corridor].length; i++) {
			minirooms[(corridor-1)][i].setLigth(false);
		}
	}
}
