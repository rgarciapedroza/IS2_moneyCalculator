package cli;

import model.Monto;
import model.Moneda;

import javax.swing.*;
import java.util.List;

public class MontoEntradaGUI extends JPanel implements MontoEntrada {
    private JComboBox<Monto> comboMonto;

    public MontoEntradaGUI() {
        comboMonto = new JComboBox<>();
        add(comboMonto);
    }

    @Override
    public void cargarMonto(List<Moneda> monedas) {
        for (Moneda moneda : monedas) {
            comboMonto.addItem(new Monto(0.0, moneda)); // Asumiendo constructor de Monto adecuado
        }
    }

    @Override
    public MontoEntrada definir(List<Moneda> monedas) {
        return null;
    }

    @Override
    public Monto obtenerMonto() {
        return (Monto) comboMonto.getSelectedItem();
    }
}
