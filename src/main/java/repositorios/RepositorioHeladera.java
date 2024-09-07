package repositorios;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;
//import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@Repository
public class RepositorioHeladera {
    private List<Heladera> heladeras;

    public RepositorioHeladera() {
        this.heladeras = new ArrayList<>();
    }

    public void agregarViandaARecibir(Heladera heladera, Vianda vianda) {
        heladera.viandasARecibir().add(vianda);
    }

    public List<Heladera> findAll() {
        return null;
    }
}
