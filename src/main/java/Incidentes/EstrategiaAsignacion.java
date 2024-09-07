package Incidentes;

import domain.tecnicos.Tecnico;
import models.entities.Heladera.Heladera;

import java.util.List;

public interface EstrategiaAsignacion {
    List<Tecnico> asignarTecnico(List<Tecnico> tecnicos, Heladera heladera);
}
