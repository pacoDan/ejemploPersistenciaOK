package Incidentes;

import models.entities.Heladera.Heladera;

public class ReceptorReporteFallas {
     Accionador accionador;

    public ReceptorReporteFallas(ReporteFalla reporteFalla) {
    }

    public void evaluar(Heladera heladera){

        this.accionador.sucedeIncidente(TipoIncidente.FALLA_TECNICA, heladera, null);
    }
}
