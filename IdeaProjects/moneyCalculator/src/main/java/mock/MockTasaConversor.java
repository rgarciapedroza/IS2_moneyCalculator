package mock;

import model.Monto;
import model.Moneda;

import java.util.List;

public class MockTasaConversor {
    public double convertir(Monto monto, Moneda moneda) {
        // Ejemplo simplificado para cargarMonedas
        return 0.0; // Supongamos que devolvemos siempre cero por ahora
    }

    public List<Moneda> cargarMonedas() {
        // Aquí cargarías las monedas desde algún lugar, por ejemplo, una base de datos
        return null; // Devolvemos null para simular que no hay monedas cargadas
    }
}
