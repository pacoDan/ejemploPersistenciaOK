package domain.reportes;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

@Getter
@Setter
public class CantidadViandasHeladera {
    private Heladera heladera;
    private int viandasRetiradas;
    private int ViandasColocadas;


}
