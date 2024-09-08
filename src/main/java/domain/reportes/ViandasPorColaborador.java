package domain.reportes;

import domain.PersonaFisica;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViandasPorColaborador {
        private PersonaFisica colaborador;
        private int cantidadViandasDonadas;


}
