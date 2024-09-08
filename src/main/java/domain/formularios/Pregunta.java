package domain.formularios;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Pregunta {
    private String enunciado;
    private List<Opcion> opciones;
    private TipoPregunta tipo;

    public Pregunta(String enunciado, List<Opcion> opciones, TipoPregunta tipo) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.tipo = tipo;
    }

}
