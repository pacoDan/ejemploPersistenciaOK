package colaboraciones.DistribuirVianda;

import domain.Colaborador;
import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class DistribuirVianda {
    private Date fechaColaboracion;
    private Integer cantidad;
    private Colaborador colaborador;
    private Motivo motivo;
    private Heladera heladeraOrigen;
    private Heladera heladeraDestino;
    private int cantViandas;

    private List<Vianda> viandasMovidas;


    public DistribuirVianda(Date fechaColaboracion, int cantidad, Heladera heladeraDestino, Heladera helderaOrigen) {
        this.fechaColaboracion = fechaColaboracion;
        this.cantidad = cantidad;
        this.heladeraDestino = heladeraDestino;
        this.heladeraOrigen = helderaOrigen;
    }

    public DistribuirVianda(int cantidad) {
        this.cantidad = cantidad;
    }

    public void ActualizarStock(){
        for (Vianda vianda : viandasMovidas) {
            heladeraOrigen.quitarVianda(vianda);
        }
        for (Vianda vianda : viandasMovidas) {
            heladeraDestino.agregarVianda(vianda);
        }
    }
}
