package model;

import java.util.ArrayList;

public class Fregadero {

    private int tamFregadero;
    private ArrayList cubiertos;

    private Fregadero (int tamanio) {
        tamFregadero = tamanio;
        cubiertos = new ArrayList();
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
    public synchronized Integer recogerCubiertos() {

        while(cubiertos.size() == 0)
            Thread.yield();

        Integer i = (Integer) cubiertos.remove(0);

        return i;
    }

    //El comensal deja los cubiertos sucios en el fregadero.
    public synchronized void dejarCubiertos() {

        while(cubiertos.size() == tamFregadero)
            Thread.yield();

        cubiertos.add(1);

        while(cubiertos.size() == tamFregadero)
            Thread.yield();

        cubiertos.add(2);
    }

}
