package domain.reportes;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

@Getter
@Setter
public class FallasDeHeladera {
    private Heladera heladera;
    private int cantidadFallas;

}
