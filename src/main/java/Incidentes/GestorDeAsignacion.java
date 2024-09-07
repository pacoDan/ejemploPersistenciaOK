package Incidentes;

import domain.tecnicos.Tecnico;
import models.entities.Heladera.Heladera;

import java.util.List;

public class GestorDeAsignacion {
    private EstrategiaAsignacion estrategiaAsignacion;

    public GestorDeAsignacion(EstrategiaAsignacion estrategiaAsignacion) {
        this.estrategiaAsignacion = estrategiaAsignacion;
    }

    public List<Tecnico> asignarTecnico(List<Tecnico> tecnicos, Heladera heladera) {
        return estrategiaAsignacion.asignarTecnico(tecnicos, heladera);
    }
}
