package Incidentes;

import domain.tecnicos.Tecnico;
import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

import java.util.List;

@Setter
@Getter
public class AvisarTecnico implements Comandos{
    Controlador controlador;
    EstrategiaNotificacionTecnicos estrategiaNotificacionTecnicos;
    @Override
    public void accionar(Heladera heladera) {
        String mensaje = "Se ha asignado un nuevo incidente en la ubicación: " + heladera.getUbicacion();
        List<Tecnico> tecnicosCerca = controlador.asignarTecnicoAIncidente(heladera);
        for(Tecnico tecnico: tecnicosCerca){
        NotificacionTecnico notificacion = new NotificacionTecnico(mensaje, tecnico );
        estrategiaNotificacionTecnicos.notificar(notificacion);

    }
}}
