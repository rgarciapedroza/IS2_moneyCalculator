

import cli.MontoEntradaGUI;
import control.ConvertirComando;
import mock.MockMonedaSelector;
import mock.MockTasaConversor;
import swing.ResultadoMostrarGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Supongamos que tienes las implementaciones adecuadas para estas clases
        MontoEntradaGUI montoEntrada = new MontoEntradaGUI();
        MockMonedaSelector monedaSelector = new MockMonedaSelector();
        MockTasaConversor tasaConversor = new MockTasaConversor();
        ResultadoMostrarGUI resultadoMostrar = new ResultadoMostrarGUI();

        ConvertirComando comando = new ConvertirComando(montoEntrada, monedaSelector, tasaConversor, resultadoMostrar);
        comando.execute();
    }
}
