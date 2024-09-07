package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaJuridica {
    private String tipoOrganizacion;

    private String razonSocial;

    public PersonaJuridica(String tipoOrganizacion, String razonSocial) {
        this.tipoOrganizacion = tipoOrganizacion;
        this.razonSocial = razonSocial;
    }


}