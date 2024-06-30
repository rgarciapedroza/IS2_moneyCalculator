package model;

public class Cantidad {
    private final double cantidad;
    private final Moneda moneda;

    public Cantidad(double cantidad, Moneda moneda) {
        this.cantidad = cantidad;
        this.moneda = moneda;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Moneda getMoneda() {
        return moneda;
    }
}
