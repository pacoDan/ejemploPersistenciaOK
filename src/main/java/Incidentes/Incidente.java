package Incidentes;

import domain.tecnicos.Tecnico;
import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

import java.util.Date;
import java.util.List;

@Setter
@Getter

public class Incidente {
    private Date fechaYHora;
    private Heladera heladera;
    private TipoIncidente tipoIncidente;
    private EstadoIncidente estadoIncidente;
    private List<Visita> visitas;
    private Tecnico tecnico;
    private Alerta alerta;

    public void agregarVisita(Visita visita) {
        visitas.add(visita);
    }

    public Boolean estaSolucionado() {
        return estadoIncidente == EstadoIncidente.SOLUCIONADO;
    }




}
