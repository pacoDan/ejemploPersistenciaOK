package Incidentes;

import domain.tecnicos.Tecnico;
import models.entities.Heladera.Heladera;

import java.util.List;

public class Controlador {
    private RepositorioTecnicos repositorioTecnicos;
    private GestorDeAsignacion gestorDeAsignacion;

    public Controlador(RepositorioTecnicos repositorioTecnicos, GestorDeAsignacion gestorDeAsignacion) {
        this.repositorioTecnicos = repositorioTecnicos;
        this.gestorDeAsignacion = gestorDeAsignacion;
    }

    public List<Tecnico> asignarTecnicoAIncidente(Heladera heladera) {
        List<Tecnico> tecnicos = repositorioTecnicos.obtenerTodos();
        return gestorDeAsignacion.asignarTecnico(tecnicos, heladera);
    }
}
