package colaboraciones.HacerseCargoDeHeladera;

import models.entities.Heladera.Punto;

import java.util.List;

public class HacerseCargoDeHeladera {
    public List<Punto> conocerPuntosIdeales(CalculadoraPuntosIdeales calculadora, Punto punto, double radio) {
        return calculadora.obtenerPuntosColocacion(punto, radio);
    }
}
