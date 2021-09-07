package model;

import java.util.ArrayList;

public class Fregadero {

    private int tamFregadero;
    private int paresCubiertos;

    private Fregadero (int tamanio) {
        tamFregadero = tamanio;
        paresCubiertos = 0;
    }

    //El lavaplatos lava los cubiertos.
    public void lavar() {

        try {
            //sleep random
            int tiempo = (int) (Math.random() * 100) % 2;
            if (tiempo == 0) {
                Thread.sleep(1000);
            } else {
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //El lavaplatos recoge cubiertos del fregadero para lavarlos.
    public synchronized void recogerCubiertos() {
        while(paresCubiertos == 0)
            Thread.yield();
        paresCubiertos--;
    }

    //El comensal deja los cubiertos sucios en el fregadero.
    public synchronized void dejarCubiertos() {

        while(paresCubiertos == tamFregadero)
            Thread.yield();

        paresCubiertos++;
    }

}
