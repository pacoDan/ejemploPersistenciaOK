package domain.puntajes;

import java.util.ArrayList;
import java.util.List;

public class CalculadorPuntaje {
    private final List<Colaboracion> colaboraciones;
    //coeficientes
    private double puntosXPESOS_DONADOS;
    private double puntosXVIANDAS_DONADAS;
    private double puntosXVIANDAS_DISTRIBUIDAS;
    private double puntosHELADERA;
    private double puntosPorTarjetasRepartidas;

    public CalculadorPuntaje(List<Colaboracion> colaboraciones) {
        this.puntosXPESOS_DONADOS = 0.5;
        this.puntosXVIANDAS_DONADAS = 1.5;
        this.puntosXVIANDAS_DISTRIBUIDAS = 1;
        this.puntosHELADERA = 5;
        this.colaboraciones= colaboraciones;
    }

    public CalculadorPuntaje() {
        this.colaboraciones= new ArrayList<Colaboracion>();
    }

    public float calcularPuntos() {
        return 0;
    }

    public long sumaPesosDonados(List<Colaboracion> colaboraciones) {
        return colaboraciones.stream().mapToLong(this::calcularPesosDonados).sum();
    }

    private long calcularPesosDonados(Colaboracion colaboracion) {
        if (colaboracion.getPesosDonados() != null) {
            return colaboracion.getPesosDonados().getMonto();
        } else return 0;
    }

    public long cantidadViandasDistribuidas(List<Colaboracion> colaboraciones) {
        return colaboraciones.stream().mapToLong(this::calcularViandasDistribuidas).sum();
    }


    private long calcularViandasDistribuidas(Colaboracion colaboracion) {
        if (colaboracion.getDistribucionVianda() != null) {
            return colaboracion.getDistribucionVianda().getCantidad();
        } else return 0;
    }

    public long cantidadViandasDonadas(List<Colaboracion> colaboraciones) {
        return colaboraciones.stream().mapToLong(this::calcularcantidadViandasDonadas).sum();
    }

    private long calcularcantidadViandasDonadas(Colaboracion colaboracion) {
        if(colaboracion.getDonacionVianda()!=null){
            return colaboracion.getDonacionVianda().getCantidad();
        }
        else return 0;
    }

    public long cantidadTarjetasRepartidas(List<Colaboracion> colaboraciones) {
        return colaboraciones.stream().mapToLong(this::calcularTarjetasRepartidas).sum();
    }

    private long calcularTarjetasRepartidas(Colaboracion colaboracion) {
        if(colaboracion.getTarjetaRepartida()!=null){
            return 1;
        }
        else return 0;
    }

    public double sumaPesosDonados() {
        return this.colaboraciones.stream().mapToLong(this::calcularPesosDonados).sum();
    }

    public double puntosHeladera() {
        return this.cantidadHeladerasActivas()*this.sumaMesesActivas()*puntosHELADERA;
    }

    private double cantidadHeladerasActivas() {
        return this.colaboraciones.stream().mapToDouble(this::calcularCantidadHeladerasActivas).sum();
    }

    private double calcularCantidadHeladerasActivas(Colaboracion colaboracion) {
        if(colaboracion.getHeladeraActiva()!=null){
            return 1;
        }
        else return 0;
//        return colaboracion.getHeladeraActiva().cantidadHeladerasActivas();

    }


    private double sumaMesesActivas() {
        return this.colaboraciones.stream().mapToDouble(this::calcularMesesActivasHeladeras).sum();
    }

    private double calcularMesesActivasHeladeras(Colaboracion colaboracion) {
        if(colaboracion.getHeladeraActiva()!=null){
            return colaboracion.getHeladeraActiva().mesesActivas();
        }
        else return 0;
//        return colaboracion.getHeladeraActiva().mesesActivas();
    }

    private long cantidadHeladeras() {
        return this.colaboraciones.stream().mapToLong(this::calcularCantidadHeladeras).sum();
    }

    private long calcularCantidadHeladeras(Colaboracion colaboracion) {
        if(colaboracion.getHeladeraActiva()!=null){
            return 1;
        }
        else return 0;
    }

    public double puntosPorPESOS_DONADOS() {
        return  this.puntosXPESOS_DONADOS*this.sumaPesosDonados();
    }

    public double puntosTarjetasRepartidas() {
        var cantidadTarjetasRepartidas= this.colaboraciones.stream().mapToDouble(this::calcularTarjetasRepartidas).sum();
        return cantidadTarjetasRepartidas*this.puntosPorTarjetasRepartidas;
    }

    public double puntosViandasDonadas() {
        var cantidadViandasDonadas= this.colaboraciones.stream().mapToDouble(this::calcularcantidadViandasDonadas).sum();
        return cantidadViandasDonadas*puntosXVIANDAS_DONADAS;
    }

    public double puntosViandasDistribuidas() {
        var cantidadViandasDistribuidas= this.colaboraciones.stream().mapToDouble(this::calcularViandasDistribuidas).sum();
        return cantidadViandasDistribuidas*puntosXVIANDAS_DISTRIBUIDAS;
    }
}
