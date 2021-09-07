package model;

public class Mesa {
	
	private int numComensales;
	private int numCubiertosT1;
	private int numCubiertosT2;
	private int numPlatos;
	
	public Mesa(int numComensales, int numCubiertosT1, int numCubiertosT2, int numPlatos)
	{
		this.numComensales = numComensales;
		this.numCubiertosT1 = numCubiertosT1;
		this.numCubiertosT2 = numCubiertosT2;
		this.numPlatos = numPlatos;
	}
	
	public void comer()
	{
		
	}
	
	public synchronized void recogerCubiertos()
	{
		
	}
	
	public synchronized void dejarCubiertos()
	{
		
	}

	public int getNumComensales() {
		return numComensales;
	}

	public void setNumComensales(int numComensales) {
		this.numComensales = numComensales;
	}

	public int getNumCubiertosT1() {
		return numCubiertosT1;
	}

	public void setNumCubiertosT1(int numCubiertosT1) {
		this.numCubiertosT1 = numCubiertosT1;
	}

	public int getNumCubiertosT2() {
		return numCubiertosT2;
	}

	public void setNumCubiertosT2(int numCubiertosT2) {
		this.numCubiertosT2 = numCubiertosT2;
	}

	public int getNumPlatos() {
		return numPlatos;
	}

	public void setNumPlatos(int numPlatos) {
		this.numPlatos = numPlatos;
	}


}
