package mock;

import cli.ResultadoMostrar;
import model.Monto;

public class MockResultadoMostrar implements ResultadoMostrar {
    @Override
    public void mostrar(Monto monto) {
        System.out.println(monto);
    }
}
