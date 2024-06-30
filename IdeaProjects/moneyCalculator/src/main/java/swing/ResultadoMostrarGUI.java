package swing;

import cli.ResultadoMostrar;
import model.Monto;

import javax.swing.*;
import java.awt.*;

public class ResultadoMostrarGUI extends JPanel implements ResultadoMostrar {
    private final JLabel label;

    public ResultadoMostrarGUI() {
        setLayout(new FlowLayout());
        label = new JLabel("Resultado: ");
        add(label);
    }

    @Override
    public void mostrar(Monto monto) {
        label.setText("Resultado: " + String.format("%.2f", monto.cantidad()) + " " + monto.moneda().nombre());
    }
}
