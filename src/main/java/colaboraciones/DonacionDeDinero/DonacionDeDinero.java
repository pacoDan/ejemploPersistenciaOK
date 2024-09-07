package colaboraciones.DonacionDeDinero;

import domain.Colaborador;

import java.util.Date;

public class DonacionDeDinero  {
    private Date fechaColaboracion;
    private Integer monto;
    private Colaborador colaborador;

    public DonacionDeDinero(Date fechaColaboracion, int monto) {
        this.fechaColaboracion = fechaColaboracion;
        this.monto = monto;
    }
    public Date getFechaColaboracion() {
        return fechaColaboracion;
    }

    public  Integer getMonto() {
        return monto;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public DonacionDeDinero(Date fechaColaboracion, Integer monto, Colaborador colaborador) {
        this.fechaColaboracion = fechaColaboracion;
        this.monto = monto;
        this.colaborador = colaborador;
    }

}
