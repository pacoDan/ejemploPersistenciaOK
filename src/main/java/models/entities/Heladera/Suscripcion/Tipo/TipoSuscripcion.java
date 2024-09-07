package models.entities.Heladera.Suscripcion.Tipo;

import domain.Colaborador;
import models.entities.Notificador.EstrategiaNotificacion;

public interface TipoSuscripcion {
public void notificar(int valor, EstrategiaNotificacion medio, Colaborador colaborador);

}
