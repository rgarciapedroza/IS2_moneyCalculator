package swing;

import cli.MontoEntradaGUI;
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
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        montoEntrada = new MontoEntradaGUI();
        monedaSelector = new MonedaSelectorGUI();
        resultadoMostrar = new ResultadoMostrarGUI();

        // Cargar monedas
        MockTasaConversor tasaConversor = new MockTasaConversor();
        List<Moneda> monedas = tasaConversor.cargarMonedas();

        // Configurar componentes
        montoEntrada.cargarMonto(monedas);
        monedaSelector.cargar(monedas);

        // Botón de conversión
        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.addActionListener(e -> {
            ConvertirComando comando = new ConvertirComando(montoEntrada, monedaSelector, tasaConversor, resultadoMostrar);
            comando.execute();
        });

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 1));
        panelPrincipal.add(new JLabel("Ingrese monto y seleccione moneda"));
        panelPrincipal.add(montoEntrada);
        panelPrincipal.add(monedaSelector);
        panelPrincipal.add(btnConvertir);

        // Agregar componentes al frame
        add(panelPrincipal, BorderLayout.CENTER);
        add(resultadoMostrar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
