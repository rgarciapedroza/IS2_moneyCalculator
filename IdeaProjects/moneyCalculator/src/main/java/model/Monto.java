package model;

public class Monto {
    private double cantidad;
    private Moneda moneda;

    public Monto(double cantidad, Moneda moneda) {
        this.cantidad = cantidad;
        this.moneda = moneda;
    }

    public double cantidad() {
        return cantidad;
    }

    public Moneda moneda() {
        return moneda;
    }
}
