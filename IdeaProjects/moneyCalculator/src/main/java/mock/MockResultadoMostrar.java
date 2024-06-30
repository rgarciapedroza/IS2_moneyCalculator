package mock;

import cli.ResultadoMostrar;
import model.Cantidad;

public class MockResultadoMostrar implements ResultadoMostrar {
    @Override
    public void mostrar(Cantidad cantidad) {
        System.out.println(cantidad);
    }
}
