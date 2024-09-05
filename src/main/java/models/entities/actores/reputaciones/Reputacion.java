package models.entities.actores.reputaciones;

import models.entities.Persistente;
import models.entities.trabajos.Calificacion;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "tipo")
public abstract class Reputacion extends Persistente {
    @Column
    private String uno;

    public abstract void recibirCalificacion(Calificacion calificacion);
}
