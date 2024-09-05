package models.entities;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Getter
public abstract class Persistente {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "fechaAlta", columnDefinition = "DATE")
    private LocalDate fechaAlta;

    public Persistente() {
        this.fechaAlta = LocalDate.now();
        this.activo = true;
    }
}
