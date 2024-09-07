package colaboraciones.EntregarTarjeta;

import domain.Colaborador;
import lombok.Getter;

import java.util.Date;
@Getter
public class RegistrarPersona {
    private Date fechaColaboracion;
    private Integer cantidad;
    private Colaborador colaborador;


    public RegistrarPersona(Date fechaColaboracion, Integer cantidad, Colaborador colaborador) {
        this.fechaColaboracion = fechaColaboracion;
        this.cantidad = cantidad;
        this.colaborador = colaborador;
    }
}
