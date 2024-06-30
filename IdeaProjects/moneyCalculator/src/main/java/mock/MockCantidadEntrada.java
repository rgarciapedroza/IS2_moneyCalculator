package mock;

import cli.CantidadEntrada;
import model.Cantidad;
import model.Moneda;

import java.util.List;

public class MockCantidadEntrada implements CantidadEntrada {
    private List<Moneda> monedas;



    @Override
    public Cantidad obtenerCantidad() {
        return null;
    }


}