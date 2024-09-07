package domain.puntajes;

import java.util.List;

public class ReconocimientoColaborador {
    private float puntosAcumulados;
    private CalculadorPuntaje calculadorPuntaje;
    public float calcularPuntos(List<Colaboracion> colaboraciones) {
        this.calculadorPuntaje= new CalculadorPuntaje(colaboraciones);
        this.puntosAcumulados=0;
        this.puntosAcumulados+= calculadorPuntaje.puntosPorPESOS_DONADOS();
        this.puntosAcumulados+= this.calculadorPuntaje.puntosViandasDistribuidas();
        this.puntosAcumulados+= this.calculadorPuntaje.puntosViandasDonadas();
        this.puntosAcumulados+= this.calculadorPuntaje.puntosTarjetasRepartidas();
        this.puntosAcumulados+= this.calculadorPuntaje.puntosHeladera();
        return puntosAcumulados;
    }

}
