package models.entities.actores.reputaciones;

import models.entities.trabajos.Calificacion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("regular")
@Table(name = "prestador_reputacion_regular")
public class ReputacionRegular extends Reputacion {
    @Column
    private String tres;

    @Override
    public void recibirCalificacion(Calificacion calificacion) {
        //TODO
    }
}
