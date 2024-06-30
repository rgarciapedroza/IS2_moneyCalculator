package mock;

import cli.MonedaSelector;
import model.Moneda;

import java.util.List;

public class MockMonedaSelector implements MonedaSelector {
    private List<Moneda> monedas;

    @Override
    public void cargar(List<Moneda> monedas) {

    }

    @Override
    public MonedaSelector definir(List<Moneda> monedas) {
        this.monedas = monedas;
        return this;
    }

    @Override
    public Moneda obtenerMoneda() {
        return null;
    }
}
