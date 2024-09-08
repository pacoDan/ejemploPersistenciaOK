package Incidentes;

import models.entities.Heladera.Heladera;
import models.entities.Heladera.SensorTemperatura;

public class ReceptorMovimiento {
    private Heladera heladera;
    private SensorTemperatura sensorMovimiento;

    public ReceptorMovimiento(SensorTemperatura sensorMovimiento) {
        this.sensorMovimiento = sensorMovimiento;
    }
    public void evaluar(Boolean movimientoDetectado){
        if(movimientoDetectado){
            Alerta alerta = new Alerta(TipoAlerta.FRAUDE);
            alerta.evaluar(heladera);
        }
    }
}
