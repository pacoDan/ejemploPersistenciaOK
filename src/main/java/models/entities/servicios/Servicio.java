package models.entities.servicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Boolean activo = true;

    @Column(name = "nombre", nullable = false)
    private String nombre;


    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "icono")
    private String icono;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id")
    private List<Tarea> tareas;

    @Column
    private Integer cantTareas;

    public Servicio() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTareas(Tarea ... tareas) {
        Collections.addAll(this.tareas, tareas);
        this.cantTareas = this.tareas.size();
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", nombre: " + this.nombre;
    }
}
