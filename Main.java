package actividad2_monitores_2;

import actividad2_monitores_2.Coches;
import java.util.Random;

import actividad2_monitores_2.Puente;

public class Main {
    public static void main(String[] args) {
        Puente puente = new Puente();
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            int direccion = rand.nextInt(2); // 0 para Norte, 1 para Sur
            new Coches(puente, direccion, i).start();
        }
    }
}