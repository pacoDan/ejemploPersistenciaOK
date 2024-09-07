package models.entities.Heladera.Suscripcion.Tipo;

import domain.Colaborador;
import models.entities.Notificador.EstrategiaNotificacion;
import models.entities.Notificador.Notificacion;

public class QuedanNviandas implements TipoSuscripcion{
    private int numSeteado;

    public QuedanNviandas(int numSeteado) {
        this.numSeteado = numSeteado;
    }
    @Override
    public void notificar(int valor, EstrategiaNotificacion medio, Colaborador colaborador) {
        if (valor >= numSeteado) {
            medio.notificar(new Notificacion("Quedan: " + valor + "vianda/s disponibles en la heladera", colaborador));
        }
    }



}
