package models.entities.Notificador.Medios;

import models.entities.Notificador.EstrategiaNotificacion;
import models.entities.Notificador.Notificacion;

public class Mail implements EstrategiaNotificacion {
    private AdapterNotificacionMail adapter;

    public Mail(AdapterNotificacionMail adapter) {
        this.adapter = adapter;
    }

    @Override
    public void notificar(Notificacion notificacion) {
        adapter.notificar(notificacion);
    }
}
