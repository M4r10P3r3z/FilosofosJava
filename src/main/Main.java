package main;

import main.Clases.Filosofo;
import main.Clases.Mesa;
import main.Clases.Tenedor;

public class Main {
    private static final int NUM_MAX_FILOSOFOS = 5;

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Tenedor[] tenedores = new Tenedor[NUM_MAX_FILOSOFOS];
        Filosofo[] filosofos = new Filosofo[NUM_MAX_FILOSOFOS];
        for (int i=0; i< NUM_MAX_FILOSOFOS; i++) {
            tenedores[i] = new Tenedor(i+1);
        }
        for (int i=0; i< NUM_MAX_FILOSOFOS; i++) {
            if (i==0) filosofos [0] = new Filosofo(tenedores[0], tenedores[NUM_MAX_FILOSOFOS - 1], 1, mesa);
            else filosofos [i] = new Filosofo(tenedores[i], tenedores[i - 1], i+1, mesa);
            new Thread(filosofos[i]).start();
        }
    }
}
