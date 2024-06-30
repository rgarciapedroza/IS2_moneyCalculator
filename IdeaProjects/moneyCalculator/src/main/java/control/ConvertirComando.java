package control;

import cli.CantidadEntrada;
import cli.MonedaSelector;
import mock.MockTasaConversor;
import cli.ResultadoMostrar;
import model.Cantidad;
import model.Moneda;

public class ConvertirComando implements Comando {
    private final CantidadEntrada cantidadEntrada;
    private final MonedaSelector monedaSelector;
    private final MockTasaConversor tasaConversor;
    private final ResultadoMostrar resultadoMostrar;

    public ConvertirComando(CantidadEntrada cantidadEntrada, MonedaSelector monedaSelector, MockTasaConversor tasaConversor, ResultadoMostrar resultadoMostrar) {
        this.cantidadEntrada = cantidadEntrada;
        this.monedaSelector = monedaSelector;
        this.tasaConversor = tasaConversor;
        this.resultadoMostrar = resultadoMostrar;
    }

    @Override
    public void execute() {
        Cantidad cantidadEntrada = this.cantidadEntrada.obtenerCantidad();
        Moneda monedaSeleccionada = this.monedaSelector.obtenerMoneda();

        double cantidadConvertida = this.tasaConversor.convertir(cantidadEntrada, monedaSeleccionada);
        Cantidad resultado = new Cantidad(cantidadConvertida, monedaSeleccionada);

        resultadoMostrar.mostrar(resultado);
    }
}
