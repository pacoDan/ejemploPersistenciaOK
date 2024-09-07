package Incidentes;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

@Setter
@Getter
public class Alerta {
    private TipoAlerta tipoAlerta;
    private Accionador accionador;

    public Alerta(TipoAlerta tipoAlerta, Accionador accionador) {
        this.tipoAlerta = tipoAlerta;
        this.accionador = accionador;


    }public Alerta(TipoAlerta tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }
    public void evaluar(Heladera heladera){

        this.accionador.sucedeIncidente(TipoIncidente.ALERTA, heladera, null);
    }
}
