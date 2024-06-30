package model;

import java.time.LocalDate;

public record TasaCambio(Moneda de, Moneda a, LocalDate fecha, double tasa) {
}
