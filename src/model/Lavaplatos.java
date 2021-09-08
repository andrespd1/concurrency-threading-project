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
            fregadero.recogerCubiertos();
            System.out.println("[LOG LAVAPLATOS] Lavaplatos recogió cubiertos");
            fregadero.lavar();
            System.out.println("[LOG LAVAPLATOS] Lavaplatos terminó de lavar cubiertos");
            mesa.dejarCubiertos();
            System.out.println("[LOG LAVAPLATOS] Lavaplatos dejó cubiertos en mesa");
        }
    }
}
