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

    @Override
    public void cargar(List<Moneda> monedas) {
        for (Moneda moneda : monedas) {
            selectorMoneda.addItem(moneda);
        }
    }

    @Override
    public MonedaSelector definir(List<Moneda> monedas) {
        return null;
    }

    @Override
    public Moneda obtenerMoneda() {
        return (Moneda) selectorMoneda.getSelectedItem();
    }
}
