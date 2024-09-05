package models.entities.servicios;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tarea")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tarea {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
