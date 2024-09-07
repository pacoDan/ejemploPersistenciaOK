package servicios;

import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;
import repositorios.RepositorioViandas;

import java.util.ArrayList;

public class ServiceViandas {
    static RepositorioViandas repositorioViandas = new RepositorioViandas();
    public ArrayList<Vianda> cantidadDeViandasARecibirDeHeladera(Heladera heladera) {
        if(repositorioViandas == null)
            this.repositorioViandas = new RepositorioViandas();
        return this.repositorioViandas.selectByHeladera(heladera);
    }
}
