package models.entities.servicios;

import models.entities.actores.Prestador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio_ofrecido")
public class ServicioOfrecido {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private Prestador prestador;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @Column
    private Float radioCoberturaEnKms;

    @Column(name = "experiencias", columnDefinition = "TEXT")
    private String experiencias;

    @ElementCollection
    @CollectionTable(name = "servicio_ofrecido_foto", joinColumns = @JoinColumn(name = "servicioOfrecido_id"))
    @Column(name = "foto")
    private List<String> fotos;

    @Column
    private Float precio;


    public ServicioOfrecido() {
        this.fotos = new ArrayList<>();
    }
}
