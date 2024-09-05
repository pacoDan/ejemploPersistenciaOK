package models.entities.actores;

import converters.MedioDeNotificacionAttributeConverter;
import models.entities.actores.reputaciones.Reputacion;
import models.entities.mediosDeNotificacion.IMedioDeNotificacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prestador")
public class Prestador {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "prestador")
    @OrderBy("dia ASC")
    private List<Disponibilidad> disponibilidades;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "cuitCuil")
    private String cuitCuil;

    @ElementCollection
    @CollectionTable(name = "prestador_email", joinColumns = @JoinColumn(name = "prestador_id", referencedColumnName = "id"))
    @Column(name = "email")
    private List<String> emails;

    @ElementCollection
    @CollectionTable(name = "prestador_telefono", joinColumns = @JoinColumn(name = "prestador_id", referencedColumnName = "id"))
    @Column(name = "telefono")
    private List<String> telefonos;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "nroDocumento")
    private String nroDocumento;

    @OneToOne
    @JoinColumn(name = "reputacion_id", referencedColumnName = "id")
    private Reputacion reputacion;

    @Convert(converter = MedioDeNotificacionAttributeConverter.class)
    @Column(name = "medioDeNotificacion")
    private IMedioDeNotificacion medioDeNotificacion;


    public Prestador() {
        this.disponibilidades = new ArrayList<>();
    }

    public void agregarDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidades.add(disponibilidad);
        disponibilidad.setPrestador(this);
    }
}
