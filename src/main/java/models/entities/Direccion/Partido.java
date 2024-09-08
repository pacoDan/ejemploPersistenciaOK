package models.entities.Direccion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Partido {
    String nombre;
    String provincia;



    public Partido(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
}
