package models.entities.Notificador.Medios;

import models.entities.Notificador.EstrategiaNotificacion;
import models.entities.Notificador.Notificacion;

public class Whatsapp implements EstrategiaNotificacion {
    private AdapterNotificacionWhatsapp adapter;

    public Whatsapp(AdapterNotificacionWhatsapp adapter) {
        this.adapter = adapter;
    }

    @Override
    public void notificar(Notificacion notificacion) {
        adapter.notificar(notificacion);
    }
}
