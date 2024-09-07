package Incidentes;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

import java.util.List;

@Setter
@Getter
public class Accionador {
    private List<Comandos> comandos;
    public void accionar(Heladera heladera){
        this.comandos.forEach(c->c.accionar(heladera));
    }
    public void registrarIncidente (TipoIncidente tipoIncidente, Heladera heladera, Alerta falla){
        Incidente incidente = FactoryIncidentes.crearAPartirDe(tipoIncidente, heladera, falla);
        heladera.agregarIncidente(incidente);
    }
    public void sucedeIncidente(TipoIncidente tipoIncidente, Heladera heladera, Alerta falla){
        this.registrarIncidente(tipoIncidente, heladera, falla);
        this.accionar(heladera);
    }

}
