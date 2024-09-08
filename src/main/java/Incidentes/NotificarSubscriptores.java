package Incidentes;

import models.entities.Heladera.Heladera;

public class NotificarSubscriptores implements Comandos{
    @Override
    public void accionar(Heladera heladera) {

        heladera.notificarSuscripciones(heladera.getViandas().size());
    }
}
