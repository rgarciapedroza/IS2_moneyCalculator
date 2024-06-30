package mock;

import cli.MontoEntrada;
import model.Moneda;
import model.Monto;

import java.util.List;

public class MockMontoEntrada implements MontoEntrada {
    private List<Moneda> monedas;

    @Override
    public void cargarMonto(List<Moneda> monedas) {

    }

    @Override
    public MontoEntrada definir(List<Moneda> monedas) {
        this.monedas = monedas;
        return this;
    }

    @Override
    public Monto obtenerMonto() {
        return null;
    }
}
