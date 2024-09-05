package models.entities.trabajos;

import lombok.Getter;
import lombok.Setter;
import models.entities.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "trabajo_calificacion")
@Setter
@Getter
public class Calificacion extends Persistente {
    @OneToOne
    @JoinColumn(name = "trabajo_id", referencedColumnName = "id")
    private Trabajo trabajo;

    @Column(name = "opinionLibre", columnDefinition = "TEXT")
    private String opinionLibre;

    @Column(name = "puntaje")
    private int puntaje;
}
