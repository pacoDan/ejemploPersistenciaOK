package models.entities.trabajos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Ubicacion {
    @Column
    private String calle;

    @Column
    private String altura;

    @Column
    private String localidad;

    @Column
    private String provincia;
}
