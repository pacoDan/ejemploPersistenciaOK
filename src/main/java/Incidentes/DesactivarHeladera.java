package Incidentes;

import models.entities.Heladera.Heladera;

public class  DesactivarHeladera implements Comandos {
    @Override
   public void accionar(Heladera heladera){
        heladera.marcarComoInactiva();
    }
}
