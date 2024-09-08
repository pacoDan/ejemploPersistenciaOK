package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TarjetaDeColaborador {
    private String codigoAlfaNumerico;
    private Date fechaDeCreacion;
    private Date fechaDeBaja;
    private boolean activa;
    private Colaborador propietario;

    public TarjetaDeColaborador(String codigoAlfaNumerico, Date fechaDeCreacion, Date fechaDeBaja, boolean activa, Colaborador propietario) {
        this.codigoAlfaNumerico = codigoAlfaNumerico;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeBaja = fechaDeBaja;
        this.activa = activa;
        this.propietario = propietario;
    }
}
