package main.Clases;

import java.util.concurrent.ThreadLocalRandom;

public class Filosofo implements Runnable {
    final Tenedor tenedorDerecho, tenedorIzquierdo;
    final int posicion;
    final Mesa mesa;

    public Filosofo(Tenedor tenedorDerecho, Tenedor tenedorIzquierdo, int posicion, Mesa mesa) {
        this.tenedorDerecho = tenedorDerecho;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.posicion = posicion;
        this.mesa=mesa;
    }
    public Tenedor getTenedorDerecho() {
        return tenedorDerecho;
    }
    public Tenedor getTenedorIzquierdo() {
        return tenedorIzquierdo;
    }
    @Override
    public String toString() {
        return String.valueOf(posicion);
    }
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("El Filosofo en la posicion "+ posicion + " está pensando");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 4001));
                System.out.println("El Filosofo en la posicion "+ posicion + " quiere comer");
                mesa.empezarComida(this);
                System.out.println("El Filosofo en la posicion "+ posicion + " está comiendo");
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5001));
                System.out.println("El Filosofo en la posicion "+ posicion + " ha terminado de comer");
                mesa.terminarComida(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
