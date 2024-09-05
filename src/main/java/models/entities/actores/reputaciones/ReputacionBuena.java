package models.entities.actores.reputaciones;

import models.entities.trabajos.Calificacion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("buena")
@Table(name = "prestador_reputacion_buena")
public class ReputacionBuena extends Reputacion {
    @Column
    private String dos;

    @Override
    public void recibirCalificacion(Calificacion calificacion) {
        //TODO
    }
}
