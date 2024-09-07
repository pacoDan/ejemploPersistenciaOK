package AccionadorTests;

import Incidentes.AvisarTecnico;
import Incidentes.Controlador;
import Incidentes.EstrategiaNotificacionTecnicos;
import Incidentes.NotificacionTecnico;
import domain.tecnicos.Tecnico;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.Punto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AvisarTecnicosTest {


        private AvisarTecnico avisarTecnico;
        private Controlador controlador;
        private EstrategiaNotificacionTecnicos estrategiaNotificacionTecnicos;
        private Heladera heladera;
        private Tecnico tecnico;

        @BeforeEach
        void setUp() {
            controlador = mock(Controlador.class);
            estrategiaNotificacionTecnicos = mock(EstrategiaNotificacionTecnicos.class);
            avisarTecnico = new AvisarTecnico();
            avisarTecnico.setControlador(controlador);
            avisarTecnico.setEstrategiaNotificacionTecnicos(estrategiaNotificacionTecnicos);
            heladera = mock(Heladera.class);
            tecnico = mock(Tecnico.class);
        }

        @Test
        void testAccionar() {
            when(heladera.getUbicacion()).thenReturn(new Punto(10, 20));
            when(controlador.asignarTecnicoAIncidente(heladera)).thenReturn(Collections.singletonList(tecnico));

            avisarTecnico.accionar(heladera);

            verify(controlador).asignarTecnicoAIncidente(heladera);
            verify(estrategiaNotificacionTecnicos).notificar(any(NotificacionTecnico.class));
        }

}
