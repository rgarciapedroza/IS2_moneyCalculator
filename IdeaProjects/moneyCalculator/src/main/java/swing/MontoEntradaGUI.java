package swing;

import cli.MontoEntrada;
import model.Monto;
import model.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MontoEntradaGUI extends JPanel implements MontoEntrada {
    private JTextField txtMonto;
    private JComboBox<Moneda> selectorMoneda;

    public MontoEntradaGUI() {
        setLayout(new FlowLayout());
        add(new JLabel("Monto: "));
        txtMonto = new JTextField(10);
        add(txtMonto);
        add(new JLabel("Moneda: "));
        selectorMoneda = new JComboBox<>();
        add(selectorMoneda);
    }

    public void establecerMonedas(List<Moneda> monedas) {
        for (Moneda moneda : monedas) {
            selectorMoneda.addItem(moneda);
        }
    }

    @Override
    public Monto obtenerMonto() {
        try {
            String textoMonto = txtMonto.getText();
            if (textoMonto.isEmpty()) {
                throw new NumberFormatException("El campo de monto está vacío.");
            }
            double cantidad = Double.parseDouble(textoMonto);
            Moneda monedaSeleccionada = (Moneda) selectorMoneda.getSelectedItem();
            return new Monto(cantidad, monedaSeleccionada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor numérico válido para el monto.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
