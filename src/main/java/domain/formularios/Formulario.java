package domain.formularios;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Formulario {
    private String nombre;
    private String descripcion;
    private List<Pregunta> preguntas;

    public Formulario(String nombre, String descripcion, List<Pregunta> preguntas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
    }

}
