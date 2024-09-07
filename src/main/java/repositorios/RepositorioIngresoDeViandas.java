package repositorios;

import colaboraciones.trazabilidad.AccionIngresarViandas;
import domain.Colaborador;
import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;

import java.util.ArrayList;

public class RepositorioIngresoDeViandas {
    class IngresoVianda {
        public IngresoVianda(Colaborador colaborador, Vianda vianda, Heladera heladera) {
        }
    }
    public RepositorioIngresoDeViandas() {
        this.ingresosViandas = new ArrayList<IngresoVianda>();
    }
    ArrayList<IngresoVianda> ingresosViandas;
    public void addAccionIngresoDeViandas(AccionIngresarViandas accionIngresarViandas) {
            this.ingresosViandas.add(new IngresoVianda(accionIngresarViandas.getColaborador(), accionIngresarViandas.getVianda(), accionIngresarViandas.getHeladera()));
    }

    public int cantidadTotalActual() {
       return ingresosViandas.size();
    }
}
