package domain.formularios;


import domain.Colaborador;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FormularioCompletado {
    private Formulario formulario;
    private Colaborador colaboradorEncuestado;
    private List<RespuestaColaborador> preguntasRespondidas;

    public FormularioCompletado(Formulario formulario, Colaborador colaboradorEncuestado, List<RespuestaColaborador> preguntasRespondidas) {
        this.formulario = formulario;
        this.colaboradorEncuestado = colaboradorEncuestado;
        this.preguntasRespondidas = preguntasRespondidas;
    }

}
