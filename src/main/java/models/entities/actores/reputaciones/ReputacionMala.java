package models.entities.actores.reputaciones;

import models.entities.trabajos.Calificacion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("mala")
@Table(name = "prestador_reputacion_mala")
public class ReputacionMala extends Reputacion {
    @Column
    private String cuatro;

    @Override
    public void recibirCalificacion(Calificacion calificacion) {
        //TODO
    }
}
