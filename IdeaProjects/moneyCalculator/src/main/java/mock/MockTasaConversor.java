package mock;

import model.Moneda;
import model.Monto;

import java.util.ArrayList;
import java.util.List;

public class MockTasaConversor {
    public List<Moneda> cargarMonedas() {
        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda("USD", "Dólar estadounidense"));
        monedas.add(new Moneda("EUR", "Euro"));
        monedas.add(new Moneda("JPY", "Yen japonés"));
        return monedas;
    }

    public double convertir(Monto monto, Moneda monedaDestino) {
        // Ejemplo de conversión: simplemente devuelve la misma cantidad para simplificar.
        return monto.cantidad();
    }
}
