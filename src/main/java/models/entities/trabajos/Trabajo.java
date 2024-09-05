package models.entities.trabajos;

import lombok.Getter;
import lombok.Setter;
import models.entities.Persistente;
import models.entities.actores.Consumidor;
import models.entities.servicios.ServicioOfrecido;
import models.entities.servicios.Tarea;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "trabajo")
@Setter
@Getter
public class Trabajo extends Persistente {
    @ManyToOne
    @JoinColumn(name = "servicioOfrecido_id", referencedColumnName = "id")
    private ServicioOfrecido servicioOfrecido;

    @ManyToOne
    @JoinColumn(name = "consumidor_id", referencedColumnName = "id")
    private Consumidor consumidor;

    @Column(name = "horaInicio", columnDefinition = "TIME")
    private LocalTime horaInicio;

    @Column(name = "horaFin", columnDefinition = "TIME")
    private LocalTime horaFin;

    @Column(name = "fechaARealizar", columnDefinition = "DATE")
    private LocalDate fechaARealizar;

    @Embedded
    private Ubicacion ubicacion;

    @ManyToMany
    @JoinTable(
            name = "trabajo_tarea",
            joinColumns = @JoinColumn(name = "trabajo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tarea_id", referencedColumnName = "id")
    )
    private List<Tarea> tareas;

    @Column(name = "aceptado")
    private Boolean aceptado;

    @Column(name = "finalizadoSegunConsumidor")
    private Boolean finalizadoSegunConsumidor;

    @Column(name = "finalizadoSegunPrestador")
    private Boolean finalizadoSegunPrestador;

    @Column
    private Float precioDeContratacion;
}
