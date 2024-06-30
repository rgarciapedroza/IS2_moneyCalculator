package cli;

import model.Moneda;
import model.TasaCambio;

public interface TasaConversor {
    TasaCambio cargar(Moneda de, Moneda a);
}
