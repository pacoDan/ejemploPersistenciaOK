package Incidentes;

import lombok.Getter;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.SensorTemperatura;
import models.entities.Heladera.Temperatura;

@Getter
public class ReceptorDeTemperatura {
    private Heladera heladera;
    private SensorTemperatura sensorTemperatura;
    private Alerta alerta;

    public ReceptorDeTemperatura(SensorTemperatura sensorTemperatura, Heladera heladera) {
        this.sensorTemperatura = sensorTemperatura;
        this.heladera = heladera;
    }
    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
    public void evaluar(Temperatura nuevaTemperatura){
        if (nuevaTemperatura != null) {
            if (heladera.getTemperaturaMaxima().getValor() > nuevaTemperatura.getValor()) {
                Alerta alerta = new Alerta(TipoAlerta.TEMPERATURA_ALTA, this.alerta.getAccionador());
                alerta.evaluar(heladera);
            } else if (nuevaTemperatura.getValor() < heladera.getTemperaturaMaxima().getValor()) {
                Alerta alerta = new Alerta(TipoAlerta.TEMPERATURA_BAJA,this.alerta.getAccionador());
                alerta.evaluar(heladera);
            }
        } else {

            Alerta alerta = new Alerta(TipoAlerta.FALLA_CONEXION);
            alerta.evaluar(heladera);
        }
    }

}
