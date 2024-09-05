package models.entities.actores;

import converters.DiaDeLaSemanaAttributeConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "prestador_disponibilidad")
@Setter
@Getter
public class Disponibilidad {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private Prestador prestador;

    @Column(name = "horaInicio", columnDefinition = "TIME")
    private LocalTime horaInicio;

    @Column(name = "horaFin", columnDefinition = "TIME")
    private LocalTime horaFin;

    @Convert(converter = DiaDeLaSemanaAttributeConverter.class)
    private DayOfWeek dia;
}
