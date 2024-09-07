package domain;

import lombok.Getter;
import lombok.Setter;
import models.entities.Direccion.Direccion;
import models.entities.Tarjeta;

import java.util.List;

@Getter
@Setter
public class PersonaFisica {


    private Direccion direccion;

    private List<Tarjeta> tarjetas;

    public PersonaFisica(){

    }
    public PersonaFisica(Direccion direccion, List<Tarjeta> tarjetas) {
        this.direccion = direccion;
        this.tarjetas = tarjetas;
    }
}
