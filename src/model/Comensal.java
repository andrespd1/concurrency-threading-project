package model;

import java.util.concurrent.CyclicBarrier;

public class Comensal extends Thread {

    private Mesa mesa;
    private Fregadero fregadero;
    private CyclicBarrier barrera;
    private int nPlatos;

    public Comensal(Mesa refMesa, Fregadero refFreg, int platos, CyclicBarrier cb) {
        mesa = refMesa;
        fregadero = refFreg;
        barrera = cb;
        nPlatos = platos;
    }

    @Override
    public void run() {
        for(int i = 0; i <nPlatos; i++) {
        	System.out.println("[LOG COMENSAL] Entra comensal plato "+ i);
            mesa.recogerCubiertos();
            System.out.println("[LOG COMENSAL] Comensal recogio los cubiertos");
            mesa.comer();
            System.out.println("[LOG COMENSAL] Comensal terminó de comer un plato");
            fregadero.dejarCubiertos();
            System.out.println("[LOG COMENSAL] Comensal dejó los cubiertos");

            if (i == Math.floor(nPlatos/2)) {
                try {
                    barrera.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("---[LOG COMENSAL] Comensal terminó todos los platos---");
    }

	public Mesa getMesa() {
		return mesa;
	}

	public Fregadero getFregadero() {
		return fregadero;
	}

	public CyclicBarrier getBarrera() {
		return barrera;
	}

	public int getnPlatos() {
		return nPlatos;
	}
    
}
