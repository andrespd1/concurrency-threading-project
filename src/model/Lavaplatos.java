package model;

public class Lavaplatos extends Thread {

    private Mesa mesa;
    private Fregadero fregadero;

    public Lavaplatos(Mesa refMesa, Fregadero refFreg) {
        mesa = refMesa;
        fregadero = refFreg;
    }

    @Override
    public void run() {
        while(true) {
            int tipoCubierto = fregadero.recogerCubiertos();
            fregadero.lavar();
            mesa.dejarCubiertos(tipoCubierto);
        }
    }
}
