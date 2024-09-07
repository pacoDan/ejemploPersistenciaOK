package domain.puntajes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
