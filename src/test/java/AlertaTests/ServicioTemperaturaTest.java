package AlertaTests;

/*
public class ServicioTemperaturaTest {


    private ServicioTemperatura servicioTemperatura;
    private RepositorioHeladera repositorioHeladera;
    private Heladera heladera;
    private Accionador accionador;
    private Alerta alerta;
    @BeforeEach
    void setUp() {
        repositorioHeladera = mock(RepositorioHeladera.class);
        servicioTemperatura = new ServicioTemperatura();
        servicioTemperatura.setRepositorioHeladera(repositorioHeladera);
        heladera = mock(Heladera.class);
        accionador = mock(Accionador.class);
        alerta = new Alerta(TipoAlerta.FALLA_CONEXION);
        alerta.setAccionador(accionador);

    }

    @Test
    void testVerificarUltimasTemperaturasConFallaDeConexion() {
        Temperatura ultimaTemperatura = mock(Temperatura.class);
        when(ultimaTemperatura.getFechaYHoraIngresada()).thenReturn(LocalDateTime.now().minus(6, ChronoUnit.MINUTES));
        when(heladera.getUltTemperatura()).thenReturn(ultimaTemperatura);

        List<Heladera> heladeras = Arrays.asList(heladera);
        when(repositorioHeladera.findAll()).thenReturn(heladeras);

        servicioTemperatura.verificarUltimasTemperaturas();

        verify(heladera).agregarIncidente(any(Incidente.class));
    }
}*/