package model;

public class Mesa {
	
	private int numComensales;
	private int numCubiertosT1;
	private int numCubiertosT2;
	
	public Mesa(int numComensales, int numCubiertosT1, int numCubiertosT2)
	{
		this.numComensales = numComensales;
		this.numCubiertosT1 = numCubiertosT1;
		this.numCubiertosT2 = numCubiertosT2;
	}

	//El comensal come en la mesa.
	public void comer()
	{
		try {
			//sleep random
			int tiempo = (int) (Math.random() * 100) % 3;
			if (tiempo == 0) {
				Thread.sleep(3000);
			} else if (tiempo == 1) {
				Thread.sleep(4000);
			} else {
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//El comensal recoge cubiertos de la mesa. Tiene que recoger uno de cada tipo.
	public synchronized void recogerCubiertos()
	{
		//Aún no ha recogido ambos cubiertos
		boolean recogidos = false;

		//Mientras que no tenga ambos...
		while(!recogidos) {

			//Espera hasta que haya cubiertos tipo 1
			while(numCubiertosT1 == 0) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//Si los hay, recoge uno.
			numCubiertosT1--;

			//Si no hay cubiertos tipo 2
			if(numCubiertosT2 == 0) {
				//Devuelve el cubierto
				numCubiertosT1++;

				//Espera a que cubierto 2 tenga disponibilidad.
				while(numCubiertosT2 == 0) {
					try {
						wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//De igual manera, no pudo recoger ambos, entonces tiene que reiniciar desde cubierto 1.

			} else {

				//Si hay cubierto tipo 2, recoga y anuncie que logró recoger ambos.
				numCubiertosT2--;
				recogidos = true;
			}
		}
	}

	//El lavaplatos deja cubiertos nuevos en la mesa. Puede dejar cualquier cubierto.
	public synchronized void dejarCubiertos(int tipoCubierto)
	{
		if(tipoCubierto == 1) {
			numCubiertosT1++;
		} else {
			numCubiertosT2++;
		}
		notify();
	}


}
