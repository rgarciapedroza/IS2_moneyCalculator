package cli;

import model.Moneda;
import model.Monto;

import java.util.List;

public interface MontoEntrada {
    void cargarMonto(List<Moneda> monedas);

    MontoEntrada definir(List<Moneda> monedas);
    Monto obtenerMonto();
}
