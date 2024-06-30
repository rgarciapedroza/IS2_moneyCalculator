package swing;

import cli.CantidadEntrada;
import model.Moneda;
import model.Cantidad;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CantidadEntradaGUI extends JPanel implements CantidadEntrada {
    private final JTextField campoCantidad;
    private JComboBox<Moneda> selectorMoneda;

    public CantidadEntradaGUI() {
        setLayout(new FlowLayout());
        campoCantidad = new JTextField(10);
        add(new JLabel("Monto:"));
        add(campoCantidad);

        selectorMoneda = new JComboBox<>();
        add(new JLabel("Moneda:"));
        add(selectorMoneda);
    }

    public void establecerMonedas(List<Moneda> monedas) {
        for (Moneda moneda : monedas) {
            selectorMoneda.addItem(moneda);
        }
    }

    @Override
    public Cantidad obtenerCantidad() {
        double cantidad = Double.parseDouble(campoCantidad.getText());
        Moneda moneda = (Moneda) selectorMoneda.getSelectedItem();
        return new Cantidad(cantidad, moneda);
    }
}
