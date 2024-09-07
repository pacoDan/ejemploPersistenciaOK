package models.entities.Vianda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Comida {
    private String nombre;

    public Comida(String nombre) {
        this.nombre = nombre;
    }
}

