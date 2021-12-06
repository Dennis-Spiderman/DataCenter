package ui;

import java.util.Scanner;

import model.DataCenter;

public class Main {

	private static Scanner in = new Scanner(System.in);
	private static Scanner in2 = new Scanner(System.in);
	private static DataCenter dc = new DataCenter();
	
	public static void main(String[] args) {
		System.out.println("Bienvenido al Data Center de la universidad ICESI");
		menu();
	}
	
	public static void menu() {
		System.out.println("\nElija la opción acorde a lo que desee hacer:" +
				"\n(1) Ver los minicuartos disponibles." +
				"\n(2) Alquilar un mini cuarto." +
				"\n(3) Cancelar el alquiler de un minicuarto." + 
				"\n(4) Ver el mapa de los mini cuartos." +
				"\n(5) Encender todos los minicuartos." +
				"\n(6) Apagar un minicuarto." +
				"\n(0) Salir.");
		
		int selection = in.nextInt();
		
		switch (selection) {
		case 1:
			seeAvailableMiniRooms();
			menu();
			break;
			
		case 2:
			rentMiniRoom();
			menu();
			break;			
		
		case 3:
			cancelMiniRoom();
			menu();
			break;			
		
		case 4:
			seeMiniRoomsMap();
			menu();
			break;			
		
		case 5:
			turnOnMiniRooms();
			menu();
			break;
		
		case 6:
			turnOffMiniRooms();
			menu();
			break;
		
		case 0:
			System.out.println("Bye :)");
			break;
		
		default:
			System.out.println("Su elección es inválida. Intente otra vez.");
			menu();
			break;
		}
	}
	
	public static void seeAvailableMiniRooms() {
		System.out.println("\n----- Ver los minicuartos disponibles -----");
		
		System.out.println(dc.seeAvailableMinirooms());		
	}
	
	public static void rentMiniRoom() {
		System.out.println("\n----- Alquilar un minicuarto -----");
		
		System.out.println("¿Para qué alquilará el minicuarto?" +
				"\n(1) Proyecto de investigación." +
				"\n(2) Uso de empresa.");
		
		int selection = in.nextInt();
		
		switch (selection) {
		case 1:
			createProjectInvestigation();
			break;
			
		case 2:
			createCompany();
			break;

		default:
			System.out.println("El valor ingresado no es válido. Intente nuevamente.");
			rentMiniRoom();
			break;
		}
	}
	
	public static void createProjectInvestigation() {
		System.out.println("\n----- Alquilar por un proyecto de investigación -----");
		
		System.out.println("Digite el número de registro del proyecto:");
		int registerNum = in.nextInt();
		
		System.out.println("Digite la fecha de hoy en formato DD/MM/AAAA:");
		String date = in2.nextLine();
		
		System.out.println("Digite la posición del minicuarto que desea rentar."
				+ "\nLos minicuartos disponibles son: ");
		seeAvailableMiniRooms();
		
		System.out.println("Corredor:");
		int corridor = in.nextInt();
		
		System.out.println("Columna:");
		int column = in.nextInt();
		
		System.out.println("Ingrese la cantidad de servidores a poner en el minicuarto:");
		int servers = in.nextInt();
		
		double[] serversCache = new double[servers];
		int[] serversProcessors = new int[servers];
		String[] serversProcessorsBrands = new String[servers];
		int[] serversRam = new int[servers];
		int[] serversDisks = new int[servers];
		String[] serversDisksCapacity = new String[servers];
		
		for (int i = 0; i < servers; i++) {
			System.out.println("Ingrese la cantidad de cache (en GB) del servidor " + (i+1) + ":");
			serversCache[i] = in.nextDouble();
			
			System.out.println("Ingrese la cantidad de procesadores del servidor " + (i+1) + ":");
			serversProcessors[i] = in.nextInt();
			
			System.out.println("Ingrese las marcas de los procesadores del servidor " + (i+1) + " poniendo una coma entre ellas:\n" 
					+ "(Ejemplo: 'AMD, Intel, Atmel, etc')");
			serversProcessorsBrands[i] = in2.nextLine();
			
			System.out.println("Ingrese la cantidad de RAM (en GB) del servidor " + (i+1) + ":");
			serversRam[i] = in.nextInt();
			
			System.out.println("Ingrese la cantidad de discos del servidor " + (i+1) + ":");
			serversDisks[i] = in.nextInt();
			
			System.out.println("Ingrese la capacidad de los discos (en teras) del servidor " + (i+1) + " poniendo una coma entre ellas:\n"
					+ "(Ejemplo: '16, 8, 32, etc')");
			serversDisksCapacity[i] = in2.nextLine(); 
		}
		
		dc.rentMiniroomByProject(date, corridor, column, registerNum, serversCache, serversProcessors, serversProcessorsBrands, serversRam, serversDisks, serversDisksCapacity);
				
		menu();
	}
	
	public static void createCompany() {
		System.out.println("\n----- Alquilar por una empresa -----");
		
		System.out.println("Digite el nit de la empresa:");
		String nit = in2.nextLine();
		
		System.out.println("Digite el nombre de la empresa:");
		String name = in2.nextLine();
		
		System.out.println("Digite la fecha de hoy en formato DD/MM/AAAA:");
		String date = in2.nextLine();
		
		System.out.println("Digite la posición del minicuarto que desea rentar."
				+ "\nLos minicuartos disponibles son: ");
		seeAvailableMiniRooms();
		
		System.out.println("Corredor:");
		int corridor = in.nextInt();
		
		System.out.println("Columna:");
		int column = in.nextInt();
		
		System.out.println("Ingrese la cantidad de servidores a poner en el minicuarto:");
		int servers = in.nextInt();
		
		double[] serversCache = new double[servers];
		int[] serversProcessors = new int[servers];
		String[] serversProcessorsBrands = new String[servers];
		int[] serversRam = new int[servers];
		int[] serversDisks = new int[servers];
		String[] serversDisksCapacity = new String[servers];
		
		for (int i = 0; i < servers; i++) {
			System.out.println("Ingrese la cantidad de cache (en GB) del servidor " + (i+1) + ":");
			serversCache[i] = in.nextDouble();
			
			System.out.println("Ingrese la cantidad de procesadores del servidor " + (i+1) + ":");
			serversProcessors[i] = in.nextInt();
			
			System.out.println("Ingrese las marcas de los procesadores del servidor " + (i+1) + " poniendo una coma entre ellas:\n" 
					+ "(Ejemplo: 'AMD, Intel, Atmel, ect')");
			serversProcessorsBrands[i] = in2.nextLine();
			
			System.out.println("Ingrese la cantidad de RAM (en GB) del servidor " + (i+1) + ":");
			serversRam[i] = in.nextInt();
			
			System.out.println("Ingrese la cantidad de discos del servidor " + (i+1) + ":");
			serversDisks[i] = in.nextInt();
			
			System.out.println("Ingrese la capacidad de los discos (en teras) del servidor " + (i+1) + " poniendo una coma entre ellas:\n"
					+ "(Ejemplo: '16, 8, 32, etc')");
			serversDisksCapacity[i] = in2.nextLine(); 
		}
		
		dc.rentMiniroomByCompany(nit, name, date, corridor, column, serversCache, serversProcessors, serversProcessorsBrands, serversRam, serversDisks, serversDisksCapacity);
	
		menu();
	}
	
	public static void cancelMiniRoom() {
		System.out.println("\n----- Cancelar alquiler de un minicuarto -----"
				+ "\nDigite la posición del minicuarto que desea cancelar.");
		
		System.out.println("Corredor:");
		int corridor = in.nextInt();
		
		System.out.println("Columna:");
		int column = in.nextInt();
		
		dc.cancelMiniroomRent(corridor, column);
		
		menu();
	}

	public static void seeMiniRoomsMap() {
		System.out.println("\n----- Ver el mapa de los minicuartos -----");
		System.out.print("[(*)]: Minicuarto encendido.\n[( )]: Minicuarto apagado.\n\n" + dc.seeAllMinirooms());
		
		menu();
	}
	
	public static void turnOnMiniRooms() {
		dc.turnOnAllMinirooms();
		
		menu();
	}
	
	public static void turnOffMiniRooms() {
		System.out.println("\n----- Apagar los minicuartos -----"
				+ "\nElija la opción acorde a lo que desee hacer:"
				+ "\n(L) Apaga los primeros minicuartos de todos los corredores, junto con los minicuartos del primer corredor."
				+ "\n(Z) Apaga los minicuartos del primer y último corredor, junto con los minicuartos de la diagonal inversa."
				+ "\n(H) Apaga los minicuartos ubicados en los corredores impares."
				+ "\n(O) Apaga los minicuartos ubicados en las ventanas."
				+ "\n(M) Pregunta al usuario una columna N y  apaga todos los minicuartos en la columna N."
				+ "\n(P) Apaga los minicuartos de un corredor que digite.");
		
		String selection = in2.nextLine();
		
		switch (selection) {
		case "L":
			turnOffL();
			break;
		
		case "Z":
			turnOffZ();
			break;
			
		case "H":
			turnOffH();
			break;
			
		case "O":
			turnOffO();
			break;
		
		case "M":
			turnOffM();
			break;
			
		case "P":
			turnOffP();
			break;
		
		default:
			System.out.println("Su elección es inválida. Intente otra vez.");
			turnOffMiniRooms();
			break;
		}
	}
	
	public static void turnOffZ() {
		
	}
	
	public static void turnOffL() {
		System.out.println("\n---- Apagar los primeros minicuartos y todo el primer corredor -----");
		dc.turnOffL();
		
		seeMiniRoomsMap();
		
		menu();
	}
	
	public static void turnOffH() {
		System.out.println("\n----- Apagar los minicuartos de los corredores impares -----");
		dc.turnOffH();
		
		seeMiniRoomsMap();
		
		menu();
	}

	public static void turnOffO() {
		System.out.println("\n----- Apagar los minicuartos con ventana -----");
		dc.turnOffO();

		seeMiniRoomsMap();
		
		menu();
	}

	public static void turnOffM() {
		System.out.println("\n----- Apagar los minicuartos de una columna -----");
		System.out.println("Digite el número de la columna que quiere apagar:");
		int column = in.nextInt();
		
		dc.turnOffM(column);
		
		seeMiniRoomsMap();
		
		menu();
	}

	public static void turnOffP() {
		System.out.println("\n----- Apagar los minicuartos de un corredor -----");
		System.out.println("Digite el número del corredor que quiere apagar:");
		int corridor = in.nextInt();
		
		dc.turnOffP(corridor);
		
		seeMiniRoomsMap();
		
		menu();
	}
}
