package domain.tecnicos;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Punto;

@Setter
@Getter
public class Area {
    private Punto centro;
    private Double radio;

    public Area(Punto centro, Double radio) {
        this.centro = centro;
        this.radio = radio;
    }
    public Boolean estaDentroDelArea(Punto punto){
        return centro.distanciaA(punto) <= radio;
    }

}
