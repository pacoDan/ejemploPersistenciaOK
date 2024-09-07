package models.entities.Heladera;

import domain.Colaborador;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SolicitudApertura {
    private Colaborador colaborador;
    private MotivoSolicitud motivo;
    private Heladera heladera;
    private Date fechaApertura;

    public SolicitudApertura(Colaborador colaborador, MotivoSolicitud motivo, Heladera heladera, Date fechaApertura) {
        this.colaborador = colaborador;
        this.motivo = motivo;
        this.heladera = heladera;
        this.fechaApertura = fechaApertura;
    }

}
