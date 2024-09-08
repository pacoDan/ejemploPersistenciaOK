package domain.formularios;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Respuesta {
    private String texto;
    private List<Opcion> opcionesMarcadas;

    public Respuesta(String texto, List<Opcion> opcionesMarcadas) {
        this.texto = texto;
        this.opcionesMarcadas = opcionesMarcadas;
    }

}
