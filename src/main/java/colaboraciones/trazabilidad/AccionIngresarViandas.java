package colaboraciones.trazabilidad;

import domain.Colaborador;
import lombok.Getter;
import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;
import repositorios.RepositorioIngresoDeViandas;

@Getter
public class AccionIngresarViandas {
    Colaborador colaborador;
    Vianda vianda;
    Heladera heladera;
    RepositorioIngresoDeViandas repoIngreso;
    public AccionIngresarViandas() {
        this.repoIngreso= new RepositorioIngresoDeViandas();
    }

    public int cantidadIngresoDeViandas() {
        return repoIngreso.cantidadTotalActual();
    }

    public void ingresarViandaARecibir(Colaborador colaborador, Vianda vianda, Heladera heladera) {
        if(repoIngreso==null){
            this.repoIngreso= new RepositorioIngresoDeViandas();
        }
        repoIngreso.addAccionIngresoDeViandas(this);
        heladera.agregarViandaARecibir(vianda);
    }
}
