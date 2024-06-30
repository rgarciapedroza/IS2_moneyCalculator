package mock;

import model.Moneda;
import model.Cantidad;

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
        tasasCambio.put("USD", 1.0);
        tasasCambio.put("EUR", 0.85);
        tasasCambio.put("JPY", 110.0);
        tasasCambio.put("GBP", 0.75);
        tasasCambio.put("AUD", 1.35);
        tasasCambio.put("CAD", 1.25);
        tasasCambio.put("CHF", 0.92);
        tasasCambio.put("CNY", 6.45);
        tasasCambio.put("INR", 74.0);
        tasasCambio.put("MXN", 20.0);
        tasasCambio.put("RON", 4.1);
    }

    public List<Moneda> cargarMonedas() {
        List<Moneda> monedas = new ArrayList<>();
        for (String codigo : tasasCambio.keySet()) {
            monedas.add(new Moneda(codigo));
        }
        return monedas;
    }

    public double convertir(Cantidad cantidad, Moneda monedaDestino) {
        double cantidadOrigen = cantidad.getCantidad();
        String codigoOrigen = cantidad.getMoneda().getCodigo();
        String codigoDestino = monedaDestino.getCodigo();

        if (!tasasCambio.containsKey(codigoOrigen) || !tasasCambio.containsKey(codigoDestino)) {
            throw new IllegalArgumentException("Moneda no soportada");
        }

        double tasaOrigen = tasasCambio.get(codigoOrigen);
        double tasaDestino = tasasCambio.get(codigoDestino);
        double cantidadConvertida = cantidadOrigen * (tasaDestino / tasaOrigen);

        BigDecimal cantidadRedondeada = new BigDecimal(cantidadConvertida).setScale(2, RoundingMode.HALF_UP);
        return cantidadRedondeada.doubleValue();
    }
}
