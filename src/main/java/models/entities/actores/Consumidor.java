package models.entities.actores;

import lombok.Getter;
import lombok.Setter;
import models.entities.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consumidor")
@Setter
@Getter
public class Consumidor extends Persistente {
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;
}
