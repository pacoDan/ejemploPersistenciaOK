package models.entities.Notificador;

import domain.Colaborador;

public class Notificacion {
    private String mensaje;

    private Colaborador receptor;

    public Notificacion(String mensaje, Colaborador receptor) {
        this.mensaje = mensaje;
        this.receptor = receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Colaborador getReceptor() {
        return receptor;
    }

    public void setReceptor(Colaborador receptor) {
        this.receptor = receptor;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
