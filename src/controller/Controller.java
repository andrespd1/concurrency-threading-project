package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

import model.Comensal;
import model.Fregadero;
import model.Lavaplatos;
import model.Mesa;

public class Controller {
	
	private static Mesa mesa;
	private static Fregadero fregadero;
	private static Lavaplatos lavaplatos;
	private static int numComensales;
	private static int numCubiertosT1;
	private static int numCubiertosT2;
	private static int numPlatos;
	private static int tamFregadero;
	private static ArrayList<Comensal> comensales;
	private static CyclicBarrier cb;
	
	//Método para cargar la información del archivo
	public static void loadData()
	{
	
		System.out.println("---[LOG CONTROLER] run loadData()---");
		int i = 0;
		
		try {
			//Abrir el File
			File f = new File("./data/properties.txt");
			//Scanner
			Scanner r = new Scanner(f);
			while(r.hasNextLine())
			{
				i += 1;
				String data  = r.nextLine();
				//Se eliminan todos los espacios en blanco del archivo properties
				data = data.replace(" ","");
				//Se hace parse del nombre de la variable y el valor
				String[] dataParsed = data.split("=");
				System.out.println("[LOG CONTROLLER] lineContent: " + data);
				//Se compara el nombre de la variable para asginarla correctamente
				if(dataParsed[0].equals("concurrencia.numComensales"))
					numComensales = Integer.parseInt(dataParsed[1]);
				else if(dataParsed[0].equals("concurrencia.numCubiertosT1"))
					numCubiertosT1 = Integer.parseInt(dataParsed[1]);
				else if(dataParsed[0].equals("concurrencia.numCubiertosT2"))
					numCubiertosT2 = Integer.parseInt(dataParsed[1]);
				else if(dataParsed[0].equals("concurrencia.numPlatos"))
					numPlatos = Integer.parseInt(dataParsed[1]);
				else if(dataParsed[0].equals("concurrencia.tamFregadero"))
					tamFregadero = Integer.parseInt(dataParsed[1]);
				else
					System.out.println("[ERROR] In line " + i + ": There isn't any variable that match with the existing");
				
			}
			r.close(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---[LOG CONTROLLER] end loadData()---");
	}
	
	public static void main(String[] args) {
		//Carga de properties
		loadData();
		//Instanciación de los objetos
		mesa = new Mesa(numComensales, numCubiertosT1, numCubiertosT2);
		fregadero = new Fregadero(tamFregadero);
		cb = new CyclicBarrier(numComensales);
		comensales = new ArrayList<>(numComensales);
		//Creación de los comensales
		for(int i = 0; i < numComensales; i++)
		{
			comensales.add(new Comensal(mesa, fregadero, numPlatos, cb));
		}
		//Start de los threads de comensales
		for(int i= 0; i < comensales.size(); i++)
		{
			comensales.get(i).start();
		}
		//Instanciacion del lavaplatos y start del thread
		lavaplatos = new Lavaplatos(mesa, fregadero);
		lavaplatos.start();
	}

}
