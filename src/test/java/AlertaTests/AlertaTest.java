package AlertaTests;

import Incidentes.Accionador;
import Incidentes.Alerta;
import Incidentes.TipoAlerta;
import Incidentes.TipoIncidente;
import models.entities.Heladera.Heladera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AlertaTest {


        private Alerta alerta;
        private Accionador accionador;
        private Heladera heladera;

        @BeforeEach
        void setUp() {
            accionador = mock(Accionador.class);
            alerta = new Alerta(TipoAlerta.TEMPERATURA_ALTA);
            alerta.setAccionador(accionador);
            heladera = mock(Heladera.class);
        }

        @Test
        void testEvaluar() {
            alerta.evaluar(heladera);

            verify(accionador).sucedeIncidente(TipoIncidente.ALERTA, heladera, null);
        }

}
