package colaboraciones.HacerseCargoDeHeladera;
import models.entities.Heladera.Punto;

import java.util.List;


public class CalculadoraPuntosIdeales {
    private AdapterReconmendadorDePuntosIdeales adapterReconmendadorDePuntosIdeales;

    public CalculadoraPuntosIdeales(AdapterReconmendadorDePuntosIdeales adapter) {
        this.adapterReconmendadorDePuntosIdeales = adapter;
    }

    public List<Punto> obtenerPuntosColocacion(Punto punto, double radio) {
        return adapterReconmendadorDePuntosIdeales.obtenerPuntosColocacion(punto, radio);
    }
}