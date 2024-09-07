package servicios;

import domain.Colaborador;
import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;
import repositorios.RepositorioEntregaDeViandas;

public class ServicioEntregaDeVianda {
    RepositorioEntregaDeViandas repositorioEntregaDeViandas;
    public ServicioEntregaDeVianda() {
        this.repositorioEntregaDeViandas = new RepositorioEntregaDeViandas();
    }

    public void entregarVianda(Colaborador colaborador, Vianda vianda, Heladera heladera) {
        this.repositorioEntregaDeViandas.add(colaborador, vianda, heladera);
    }

    public int cantidadPendienteDeViandasDeHeladera(Heladera heladera) {
        return this.repositorioEntregaDeViandas.countByHeladera(heladera);
    }
}
