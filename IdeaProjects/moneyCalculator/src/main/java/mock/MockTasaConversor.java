package mock;

import model.Moneda;
import model.Monto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockTasaConversor {
    private final Map<String, Double> tasasCambio;

    public MockTasaConversor() {
        tasasCambio = new HashMap<>();
        // Tasas de cambio ficticias
        tasasCambio.put("USD", 1.0);         // USD es la moneda base
        tasasCambio.put("EUR", 0.85);        // 1 USD = 0.85 EUR
        tasasCambio.put("JPY", 110.0);       // 1 USD = 110 JPY
    }

    public List<Moneda> cargarMonedas() {
        List<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda("USD", "Dólar estadounidense"));
        monedas.add(new Moneda("EUR", "Euro"));
        monedas.add(new Moneda("JPY", "Yen japonés"));
        return monedas;
    }

    public double convertir(Monto monto, Moneda monedaDestino) {
        double tasaOrigen = tasasCambio.get(monto.moneda().codigo());
        double tasaDestino = tasasCambio.get(monedaDestino.codigo());
        double cantidadConvertida = monto.cantidad() * (tasaDestino / tasaOrigen);
        BigDecimal cantidadRedondeada = new BigDecimal(cantidadConvertida).setScale(2, RoundingMode.HALF_UP);
        return cantidadRedondeada.doubleValue();
    }
}
