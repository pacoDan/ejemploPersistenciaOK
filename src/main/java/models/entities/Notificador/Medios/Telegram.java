package models.entities.Notificador.Medios;

import models.entities.Notificador.EstrategiaNotificacion;
import models.entities.Notificador.Notificacion;

public class Telegram implements EstrategiaNotificacion {
    private AdapterNotificacionTelegram adapter;

    public Telegram(AdapterNotificacionTelegram adapter) {
        this.adapter = adapter;
    }
    @Override
    public void notificar(Notificacion notificacion) {
        adapter.notificar(notificacion);
    }
}
