package control;

import cli.MontoEntrada;
import cli.MonedaSelector;
import cli.ResultadoMostrar;
import mock.MockTasaConversor;
import model.Monto;
import model.Moneda;

public class ConvertirComando implements Comando {
    private final MontoEntrada montoEntrada;
    private final MonedaSelector monedaSelector;
    private final MockTasaConversor tasaConversor;
    private final ResultadoMostrar resultadoMostrar;

    public ConvertirComando(MontoEntrada montoEntrada, MonedaSelector monedaSelector, MockTasaConversor tasaConversor, ResultadoMostrar resultadoMostrar) {
        this.montoEntrada = montoEntrada;
        this.monedaSelector = monedaSelector;
        this.tasaConversor = tasaConversor;
        this.resultadoMostrar = resultadoMostrar;
    }

    @Override
    public void execute() {
        Monto monto = this.montoEntrada.obtenerMonto();
        if (monto == null) {
            // Si obtenerMonto devuelve null, no continuamos con la conversión.
            return;
        }
        Moneda monedaSeleccionada = this.monedaSelector.obtenerMoneda();
        double cantidadConvertida = this.tasaConversor.convertir(monto, monedaSeleccionada);
        Monto resultado = new Monto(cantidadConvertida, monedaSeleccionada);
        resultadoMostrar.mostrar(resultado);
    }
}
