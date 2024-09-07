package colaboraciones.HacerseCargoDeHeladera;

import models.entities.Heladera.Punto;

import java.util.List;

public interface AdapterReconmendadorDePuntosIdeales {
    List<Punto> obtenerPuntosColocacion(Punto punto, double radio);
}