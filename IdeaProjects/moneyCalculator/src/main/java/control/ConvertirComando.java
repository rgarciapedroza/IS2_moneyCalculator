package control;

import cli.MontoEntrada;
import cli.MonedaSelector;
import mock.MockTasaConversor;
import cli.ResultadoMostrar;
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
        // Obtener el monto de entrada y la moneda seleccionada
        Monto monto = this.montoEntrada.obtenerMonto(); // Asegúrate de que este método no devuelva null
        Moneda monedaSeleccionada = this.monedaSelector.obtenerMoneda(); // Asegúrate de que este método no devuelva null

        // Realizar la conversión usando el tasaConversor
        double cantidadConvertida = this.tasaConversor.convertir(monto, monedaSeleccionada);

        // Crear el objeto Monto con la cantidad convertida y la moneda
        Monto resultado = new Monto(cantidadConvertida, monedaSeleccionada);

        // Mostrar el resultado en la interfaz gráfica
        resultadoMostrar.mostrar(resultado);
    }
}
