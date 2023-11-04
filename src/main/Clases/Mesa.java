package main.Clases;

public class Mesa {
    public Mesa() {
    }
    public synchronized void empezarComida(Filosofo filosofo) throws InterruptedException {
        //Si el filósofo tiene una posición par intentará coger el tenedor de la derecha
        //si la tiene impar el de la izquierda así evito un deadlock en el que todos los filósofos
        //tengán un tenedor y no puedan conseguir el otro
        if (filosofo.posicion%2==0) {
            while (filosofo.getTenedorDerecho().isTenedorOcupado()) {
                wait();
            }
            System.out.println("El filósofo "+ filosofo + " coge el tenedor "+ filosofo.getTenedorDerecho());
            filosofo.getTenedorDerecho().setTenedorOcupado(true);
            while (filosofo.getTenedorIzquierdo().isTenedorOcupado()) {
                wait();
            }
            System.out.println("El filósofo "+ filosofo + " coge el tenedor "+ filosofo.getTenedorIzquierdo());
            filosofo.getTenedorIzquierdo().setTenedorOcupado(true);
        } else {
            while (filosofo.getTenedorIzquierdo().isTenedorOcupado()) {
                wait();
            }
            System.out.println("El filósofo "+ filosofo + " coge el tenedor "+ filosofo.getTenedorIzquierdo());
            filosofo.getTenedorIzquierdo().setTenedorOcupado(true);
            while (filosofo.getTenedorDerecho().isTenedorOcupado()) {
                wait();
            }
            System.out.println("El filósofo "+ filosofo + " coge el tenedor "+ filosofo.getTenedorDerecho());
            filosofo.getTenedorDerecho().setTenedorOcupado(true);
        }
    }
    public synchronized void terminarComida(Filosofo filosofo) {
        System.out.println("El filósofo "+ filosofo + " suelta los tenedores "+ filosofo.getTenedorIzquierdo() +
                " y " + filosofo.getTenedorDerecho());
        filosofo.getTenedorIzquierdo().setTenedorOcupado(false);
        filosofo.getTenedorDerecho().setTenedorOcupado(false);
        notifyAll();
    }
}
