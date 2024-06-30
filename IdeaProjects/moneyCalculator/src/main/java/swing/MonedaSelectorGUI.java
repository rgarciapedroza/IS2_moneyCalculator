package swing;

import cli.MonedaSelector;
import model.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MonedaSelectorGUI extends JPanel implements MonedaSelector {
    private JComboBox<Moneda> selectorMoneda;

    public MonedaSelectorGUI() {
        setLayout(new FlowLayout());
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
    public Moneda obtenerMoneda() {
        return (Moneda) selectorMoneda.getSelectedItem();
    }
}
