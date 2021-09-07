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
            mesa.recogerCubiertos();
            mesa.comer();
            fregadero.dejarCubiertos();

            if (i == Math.floor(nPlatos/2)) {
                try {
                    barrera.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
