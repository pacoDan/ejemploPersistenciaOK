package Incidentes;

import models.entities.Heladera.Heladera;

import java.util.ArrayList;
import java.util.Date;

public class FactoryIncidentes {
    private static GestorDeAsignacion gestorDeAsignacion;
    public static Incidente crearAPartirDe(TipoIncidente tipoIncidente, Heladera heladera, Alerta falla) {
        Incidente nuevoIncidente = new Incidente();
        nuevoIncidente.setTipoIncidente(tipoIncidente);
        //nuevoIncidente.setTecnico(gestorDeAsignacion.asignarTecnico(nuevoIncidente));
        nuevoIncidente.setTecnico(null);
        nuevoIncidente.setHeladera (heladera);
        nuevoIncidente.setEstadoIncidente(EstadoIncidente.PENDIENTE);
       // nuevoIncidente.setFechaYHora(LocalDateTime.now());
        nuevoIncidente.setAlerta(falla);
        nuevoIncidente.setVisitas(new ArrayList<>());
        nuevoIncidente.setFechaYHora(new Date());


        return nuevoIncidente;
    }
}
