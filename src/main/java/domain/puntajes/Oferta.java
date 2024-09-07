package domain.puntajes;

import domain.canjes.ProductoCanjeable;

import java.util.Date;

public class Oferta {
    private ProductoCanjeable producto;
    private double puntosRequeridos;
    private boolean disponibleParaCanjear;
    private Date fechaDeCanje;

    public Oferta(ProductoCanjeable producto, double puntosRequeridos) {
        this.puntosRequeridos=puntosRequeridos;
        this.producto=producto;
    }
    public double puntosRequeridos() {
        return this.puntosRequeridos;
    }

    public void FueCanjeado() {
        this.fechaDeCanje= new Date();
    }
    public boolean estaDisponibleParaCanjear(){
        return fechaDeCanje==null;
    }
}
