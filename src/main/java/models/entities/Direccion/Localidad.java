package models.entities.Direccion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Localidad {
    String nombre;
    Partido partido;

    public Localidad (String nombre, Partido partido){
        this.nombre = nombre;
        this.partido = partido;
    }
}
