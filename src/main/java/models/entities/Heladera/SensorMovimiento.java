package models.entities.Heladera;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorMovimiento {
   /* private Distancia distanciaActual;
    private List<Distancia> mediciones;*/
    private Heladera heladera;

   /* public SensorMovimiento(Distancia distanciaActual, List<Distancia> mediciones) {
        this.distanciaActual = distanciaActual;
        this.mediciones = mediciones;
    }

    /*public MensajeAlerta enviarAlerta(){
        String nombreHeladera = heladera.getNombre();
        MensajeAlerta mensaje = new MensajeAlerta();
        mensaje.setTitulo("ALERTA INFRACCION");
        mensaje.setCuerpo("La Heladera:"+ nombreHeladera +" se esta alejando de su ubicacion");
        return mensaje;
    }*/
    public Boolean detectarMovimiento(){
        return false;
    }


}
