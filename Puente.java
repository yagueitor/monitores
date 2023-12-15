package actividad2_monitores_2;

import java.util.ArrayList;

class Puente {
    private ArrayList<Integer> cochesNorte = new ArrayList<>();
    private ArrayList<Integer> cochesSur = new ArrayList<>();

    public void cruzarNorte(int coche) throws InterruptedException {
        synchronized (this) {
            while (!cochesSur.isEmpty()) {
                wait();
            }
            cochesNorte.add(coche);
            System.out.println("Coche del Norte #" + coche + " cruzando el puente");
            cochesNorte.remove(Integer.valueOf(coche));
            if (cochesNorte.isEmpty()) {
                notifyAll();
            }
        }
    }

    public void cruzarSur(int coche) throws InterruptedException {
        synchronized (this) {
            while (!cochesNorte.isEmpty()) {
                wait();
            }
            cochesSur.add(coche);
            System.out.println("Coche del Sur #" + coche + " cruzando el puente");
            cochesSur.remove(Integer.valueOf(coche));
            if (cochesSur.isEmpty()) {
                notifyAll();
            }
        }
    }
}