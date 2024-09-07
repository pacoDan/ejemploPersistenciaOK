package AccionadorTests;

import Incidentes.*;
import models.entities.Heladera.Heladera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class AccionadorTest {
    @Mock
    private Accionador accionador;
    @Mock
    private Comandos comando1;
    @Mock
    private Comandos comando2;
    @Mock
    private Heladera heladera;
    @Mock
    private FactoryIncidentes factory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        accionador = new Accionador();
        heladera = mock(Heladera.class);
        accionador.setComandos(Arrays.asList(comando1, comando2));
    }
    @Test
    void testAccionar() {
        accionador.accionar(heladera);

        verify(comando1).accionar(heladera);
        verify(comando2).accionar(heladera);
    }
    @Test
    void testRegistrarIncidente() {
        TipoIncidente tipoIncidente = TipoIncidente.ALERTA;
        Alerta falla = new Alerta(TipoAlerta.TEMPERATURA_ALTA);
        Incidente incidente = mock(Incidente.class);


        mockStatic(FactoryIncidentes.class);


        when(FactoryIncidentes.crearAPartirDe(tipoIncidente, heladera, falla)).thenReturn(incidente);


        accionador.registrarIncidente(tipoIncidente, heladera, falla);


        verify(heladera).agregarIncidente(incidente);
    }

    @Test
    void testSucedeIncidente() {
        TipoIncidente tipoIncidente = TipoIncidente.ALERTA;
        Alerta falla = new Alerta(null);
        Incidente incidente = mock(Incidente.class);


        //mockStatic(FactoryIncidentes.class);
        when(FactoryIncidentes.crearAPartirDe(tipoIncidente, heladera, falla)).thenReturn(incidente);


        accionador.sucedeIncidente(tipoIncidente, heladera, falla);


        verify(heladera).agregarIncidente(incidente);
        //verify(comando1).accionar(heladera);
       // verify(comando2).accionar(heladera);
    }
}
