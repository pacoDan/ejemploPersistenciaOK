package models.entities.Heladera;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SensorTemperatura {
    private Temperatura temperaturaActual;
    private List<Temperatura> mediciones;
    private Heladera heladera;
    private Temperatura ultimaTemp;

   public SensorTemperatura(Temperatura temperaturaActual, List<Temperatura> mediciones) {
        this.temperaturaActual = temperaturaActual;
        this.mediciones = mediciones;
    }
    public void TomarTemperatura (){
        this.temperaturaActual.setFechaYHoraIngresada(LocalDateTime.now());
        this.temperaturaActual.setValor( Math.random() * 10);
        heladera.setUltTemperatura(temperaturaActual);
    }



}
