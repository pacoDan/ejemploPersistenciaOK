package models.entities.Heladera.Suscripcion.Tipo;

import domain.Colaborador;
import models.entities.Notificador.EstrategiaNotificacion;
import models.entities.Notificador.Notificacion;

public class HeladeraSufrioDesperfecto implements TipoSuscripcion{


    @Override
    public void notificar(int valor, EstrategiaNotificacion medio, Colaborador colaborador) {

        medio.notificar(new Notificacion("Heladera sufrió desperfecto y actualmente hay " + valor + " vianda/s en la heladera", colaborador));
    }
}

