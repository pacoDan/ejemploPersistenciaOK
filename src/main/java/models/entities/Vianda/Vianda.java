package models.entities.Vianda;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

import java.util.Date;
import java.util.List;
@Getter
@Setter

public class Vianda {
    private String nombre;
    private List<Comida> comida;
    private Date fechaDeCaducidad;
    private Date fechaDeDonacion;
    private Heladera heladera;
    private boolean fueEntregada;
    private int peso;
    private int calorias;

    public Vianda(List<Comida> comida, Date fechaDeCaducidad, Date fechaDeDonacion, Heladera heladera, boolean fueEntregada, Integer peso, Integer calorias) {
        this.comida = comida;
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.fechaDeDonacion = fechaDeDonacion;
        this.heladera = heladera;
        this.fueEntregada = fueEntregada;
        this.peso = peso;
        this.calorias = calorias;
    }

    public Vianda() {

    }

    public Vianda(String unaVianda) {
        this.nombre= unaVianda;
    }

    public Heladera getHeladera() {
        return heladera;
    }

    public void setHeladera(Heladera heladera) {
        this.heladera = heladera;
    }
}
