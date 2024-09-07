package colaboraciones.DistribuirVianda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motivo {
    private String descripcion;

    public Motivo(String descripcion){
        this.descripcion = descripcion;

    }
}
