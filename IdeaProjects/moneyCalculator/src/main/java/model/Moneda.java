package model;

public record Moneda(String codigo, String nombre) {
    public Moneda {
        if (codigo == null || nombre == null) {
            throw new IllegalArgumentException("Código y nombre no pueden ser nulos");
        }
    }

    @Override
    public String toString() {
        return codigo + "-" + nombre;
    }
}
