package actividad2_monitores_2;

class Coches extends Thread {
    private Puente puente;
    private int direccion; // 0 para Norte, 1 para Sur
    private int numeroCoche;

    public Coches(Puente puente, int direccion, int numeroCoche) {
        this.puente = puente;
        this.direccion = direccion;
        this.numeroCoche = numeroCoche;
    }

    public void run() {
        try {
            if (direccion == 0) {
                puente.cruzarNorte(numeroCoche);
            } else {
                puente.cruzarSur(numeroCoche);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
