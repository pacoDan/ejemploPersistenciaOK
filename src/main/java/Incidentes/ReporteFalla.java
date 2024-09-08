package Incidentes;

import domain.Colaborador;
import lombok.Setter;

import java.util.Date;
@Setter
public class ReporteFalla {
    private Colaborador reportadoPor;
    private String fotoURL;
    private String descripcion;
    private Date fechaYHora;

    public ReporteFalla(Colaborador colaborador, String descripcion, String foto) {
        this.descripcion = descripcion;
        this.fotoURL = foto;
        this.fechaYHora = new Date();
        this.reportadoPor = colaborador;
    }

}
