package domain.puntajes;

import colaboraciones.DistribuirVianda.DistribuirVianda;
import colaboraciones.DonacionDeDinero.DonacionDeDinero;
import colaboraciones.DonacionVianda.DonacionVianda;
import domain.Colaborador;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
@Getter
//@Entity
//@Table(name = "colaboracion")
public class Colaboracion {
    @Id
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "distribucion_vianda_id")
    private DistribuirVianda distribucionVianda;
    private DonacionVianda donacionVianda;
    @Getter
    private DonacionDeDinero pesosDonados;
    private TarjetaRepartida tarjetaRepartida;
    //    private HeladeraActiva heladeraActiva;
    private HeladerasActivas heladeraActivas;

    private Date fechaColaboracion;

    public void setDistribucionVianda(DistribuirVianda distribucionVianda) {
        this.distribucionVianda = distribucionVianda;
    }


    public Colaboracion(DistribuirVianda distribucionVianda) {
        this.distribucionVianda = distribucionVianda;
    }

    public Colaboracion() {
        this.fechaColaboracion = new Date();
    }
    public Colaboracion(DonacionVianda unaDonacion) {
        this();
        this.donacionVianda = unaDonacion;
    }


    public Colaboracion(DonacionDeDinero pesosDonados){
        this();
        this.pesosDonados = pesosDonados;
    }

    public DistribuirVianda getDistribucionVianda() {
        return this.distribucionVianda;
    }

    public DonacionVianda getDonacionVianda() {
        return this.donacionVianda;
    }

    public TarjetaRepartida getTarjetaRepartida() {
        return tarjetaRepartida;
    }


    public HeladerasActivas getHeladeraActiva() {
        return this.heladeraActivas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setColaborador(Colaborador daniel) {
    }
}
