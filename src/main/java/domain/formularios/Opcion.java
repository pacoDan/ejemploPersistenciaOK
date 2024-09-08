package domain.formularios;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Opcion {
    private String texto;

    public Opcion(String texto) {
        this.texto = texto;
    }

}
