package AlertaTests;

/*
public class ReceptorDeTemperaturaTest {

    private ReceptorDeTemperatura receptorDeTemperatura;
    private Heladera heladera;
    private SensorTemperatura sensorTemperatura;
    private Accionador accionador;

    @BeforeEach
    void setUp() {
        heladera = mock(Heladera.class);
        sensorTemperatura = mock(SensorTemperatura.class);
        accionador = mock(Accionador.class);
        receptorDeTemperatura = new ReceptorDeTemperatura(sensorTemperatura, heladera);
    }

    @Test
    void testEvaluarTemperaturaAlta() {
        Temperatura nuevaTemperatura = new Temperatura(15.0, null);
        when(heladera.getTemperaturaMaxima()).thenReturn(new Temperatura(10.0, null));

        Alerta alerta = new Alerta(TipoAlerta.TEMPERATURA_ALTA, accionador);
        receptorDeTemperatura.setAlerta(alerta);
        receptorDeTemperatura.evaluar(nuevaTemperatura);

        verify(heladera).agregarIncidente(any(Incidente.class));
    }

    @Test
    void testEvaluarFallaConexion() {
        Alerta alerta = new Alerta(TipoAlerta.FALLA_CONEXION, accionador);
        receptorDeTemperatura.setAlerta(alerta);
        receptorDeTemperatura.evaluar(null);

        verify(heladera).agregarIncidente(any(Incidente.class));
    }}
*/