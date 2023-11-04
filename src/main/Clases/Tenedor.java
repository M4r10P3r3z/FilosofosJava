package main.Clases;

public class Tenedor {
    final int posicion;
    boolean tenedorOcupado;

    public Tenedor(int posicion) {
        this.posicion = posicion;
        this.tenedorOcupado = false;
    }
    public boolean isTenedorOcupado() {
        return tenedorOcupado;
    }
    public void setTenedorOcupado(boolean tenedorOcupado) {
        this.tenedorOcupado = tenedorOcupado;
    }
    @Override
    public String toString() {
        return String.valueOf(posicion);
    }
}
