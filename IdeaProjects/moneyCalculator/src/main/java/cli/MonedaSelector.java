package cli;

import model.Moneda;

import java.util.List;

public interface MonedaSelector {
    void cargar(List<Moneda> monedas);

    MonedaSelector definir(List<Moneda> monedas);
    Moneda obtenerMoneda();
}
