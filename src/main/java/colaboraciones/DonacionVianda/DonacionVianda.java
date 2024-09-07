package colaboraciones.DonacionVianda;

import domain.Colaborador;
import lombok.Getter;
import lombok.Setter;
import models.entities.Vianda.Vianda;

import java.util.Date;


@Getter
@Setter
public class DonacionVianda {
    private Date fechaColaboracion;
    private Integer cantidad;
    private Colaborador colaborador;
    private Vianda vianda;
    public DonacionVianda(Date fechaColaboracion, Integer cantidad, Colaborador colaborador, Vianda vianda ) {
        this.fechaColaboracion = fechaColaboracion;
        this.cantidad = cantidad;
        this.colaborador = colaborador;
        this.vianda = vianda;
    }


    public DonacionVianda(Date fechaColaboracion, int cantidad, Vianda vianda) {
        this.fechaColaboracion = fechaColaboracion;
        this.cantidad = cantidad;
        this.vianda = vianda;
    }
}
