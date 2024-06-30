package swing;

import control.ConvertirComando;
import mock.MockTasaConversor;
import model.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private final MontoEntradaGUI montoEntrada;
    private final MonedaSelectorGUI monedaSelector;
    private final ResultadoMostrarGUI resultadoMostrar;

    public MainFrame() {
        setTitle("Convertidor de Moneda");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        montoEntrada = new MontoEntradaGUI();
        monedaSelector = new MonedaSelectorGUI();
        resultadoMostrar = new ResultadoMostrarGUI();

        MockTasaConversor tasaConversor = new MockTasaConversor();
        List<Moneda> monedas = tasaConversor.cargarMonedas();

        montoEntrada.establecerMonedas(monedas);
        monedaSelector.establecerMonedas(monedas);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.addActionListener(e -> {
            ConvertirComando comando = new ConvertirComando(montoEntrada, monedaSelector, tasaConversor, resultadoMostrar);
            comando.execute();
        });

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1));
        panelPrincipal.add(new JLabel("Ingrese monto y seleccione moneda"));
        panelPrincipal.add(montoEntrada);
        panelPrincipal.add(monedaSelector);
        panelPrincipal.add(btnConvertir);

        add(panelPrincipal, BorderLayout.CENTER);
        add(resultadoMostrar, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
