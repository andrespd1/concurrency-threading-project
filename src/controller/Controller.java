package controller;

import java.io.File;
import java.util.Scanner;

public class Controller {
	
	
	public static void loadData()
	{
		System.out.println("---[LOG] run loadData()---");
		int numComensales = -1;
		int numCubiertosT1 = -1;
		int numCubiertosT2 = -1;
		int numPlatos = -1;
		int tamFregadero = -1;
		int i = 0;
		
		try {
			File f = new File("./data/properties.txt");
			Scanner r = new Scanner(f);
			while(r.hasNextLine())
			{
				i += 1;
				String data  = r.nextLine();
				data = data.replace(" ","");
				String[] dataParsed = data.split("=");
				System.out.println("[LOG] lineContent: " + data);
				
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
		System.out.println("---[LOG] end loadData()---");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadData();

	}

}
