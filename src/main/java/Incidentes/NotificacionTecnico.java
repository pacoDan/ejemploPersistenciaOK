package Incidentes;

import domain.tecnicos.Tecnico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacionTecnico {
    private String mensaje;

    private Tecnico receptor;

    public NotificacionTecnico(String mensaje, Tecnico receptor) {
        this.mensaje = mensaje;
        this.receptor = receptor;
    }

}
