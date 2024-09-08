package domain.formularios;

import domain.Colaborador;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RespuestaColaborador {
    private Pregunta pregunta;
    private Respuesta respuesta;
    private Colaborador colaborador;

    public RespuestaColaborador(Pregunta pregunta, Respuesta respuesta, Colaborador colaborador) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.colaborador = colaborador;
    }

}
