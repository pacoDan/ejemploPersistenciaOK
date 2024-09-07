package repositorios;

import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;

import java.util.ArrayList;
import java.util.List;

public class RepositorioViandas {
    List<Vianda> viandas = new ArrayList<>();
    public RepositorioViandas() {
        this.viandas = new ArrayList<>();
    }
    public ArrayList<Vianda> selectByHeladera(Heladera heladera) {
        ArrayList<Vianda> viandasARecibir = new ArrayList<>();
        for (Vianda vianda : viandas) {
            if (vianda.getHeladera().equals(heladera)) {
                viandasARecibir.add(vianda);
            }
        }
        return viandasARecibir;
    }
    public void insert(Vianda vianda) {
        viandas.add(vianda);
    }
}
