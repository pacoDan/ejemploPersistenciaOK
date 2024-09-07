package repositorios;

import domain.Colaborador;
import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;

import java.util.ArrayList;
import java.util.Date;

public class RepositorioEntregaDeViandas {

    private ArrayList<EntregaDeViandas> repoEntregaDeViandas;
    public void add(Colaborador colaborador, Vianda vianda, Heladera heladera) {
        EntregaDeViandas entregaDeViandas = new EntregaDeViandas(colaborador, vianda, heladera);
        entregaDeViandas.fechaDeEnvio= new Date();
        repoEntregaDeViandas.add(entregaDeViandas);
    }

    public int countByHeladera(Heladera heladera) {
        return (int) repoEntregaDeViandas.stream().filter(entregaDeViandas -> entregaDeViandas.heladera.equals(heladera)).count();
    }

    public static class EntregaDeViandas {
        Date fechaDeEnvio;
        Colaborador colaborador;
        Vianda vianda;
        Heladera heladera;
        public EntregaDeViandas(Colaborador colaborador, Vianda vianda, Heladera heladera) {
            this.colaborador = colaborador;
            this.vianda = vianda;
            this.heladera = heladera;
        }
    }
    public RepositorioEntregaDeViandas() {
        this.repoEntregaDeViandas = new ArrayList<>();
    }
}
