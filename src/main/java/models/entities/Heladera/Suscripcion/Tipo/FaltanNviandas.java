package models.entities.Heladera.Suscripcion.Tipo;

import domain.Colaborador;
import models.entities.Notificador.EstrategiaNotificacion;
import models.entities.Notificador.Notificacion;

public class FaltanNviandas implements TipoSuscripcion{
    private Integer numSeteado;

    @Override
    public void notificar(int valor, EstrategiaNotificacion medio, Colaborador colaborador) {
        if (valor <= numSeteado) {
            medio.notificar(new Notificacion("Faltan: " + valor + "vianda/s para llenar la heladera", colaborador));
        }
    }
}
