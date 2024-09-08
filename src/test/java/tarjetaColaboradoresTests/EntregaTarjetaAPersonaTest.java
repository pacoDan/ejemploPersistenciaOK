package tarjetaColaboradoresTests;

import domain.Colaborador;
import models.entities.PersonaEnSituacionVulnerable;
import models.entities.Tarjeta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicios.ServicioEntregaTarjeta;

public class EntregaTarjetaAPersonaTest {
    @Test
    @DisplayName("entrega de tarjeta a persona vulnerable")
    void conteoDeEntregaTarjeta() {
        Colaborador colaborador = new Colaborador();
        Tarjeta tarjeta = new Tarjeta();
        PersonaEnSituacionVulnerable persona = new PersonaEnSituacionVulnerable();

        ServicioEntregaTarjeta servicioEntregaTarjeta = new ServicioEntregaTarjeta();
        servicioEntregaTarjeta.enviarTarjeta(colaborador, tarjeta, persona);
        Assertions.assertEquals(1, servicioEntregaTarjeta.cantidadDeTarjetasPendienteAEntregar());
    }

    @Test
    @DisplayName("persona vulnerable espera tarjeta")
    void personaEsperaTarjeta() {
        Colaborador colaborador = new Colaborador();
        Tarjeta tarjeta = new Tarjeta();
        PersonaEnSituacionVulnerable persona = new PersonaEnSituacionVulnerable();

        ServicioEntregaTarjeta servicioEntregaTarjeta = new ServicioEntregaTarjeta();
        servicioEntregaTarjeta.enviarTarjeta(colaborador, tarjeta, persona);
        Assertions.assertEquals(1, servicioEntregaTarjeta.cantidadDeTarjetasPendientesSegunPersona(persona));
    }

    @Test
    @DisplayName("persona vulnerable NO espera tarjeta")
    void personaNoEsperaTarjeta() {
        Colaborador colaborador = new Colaborador();
        Tarjeta tarjeta = new Tarjeta();
        PersonaEnSituacionVulnerable persona = new PersonaEnSituacionVulnerable();

        ServicioEntregaTarjeta servicioEntregaTarjeta = new ServicioEntregaTarjeta();
        Assertions.assertEquals(0, servicioEntregaTarjeta.cantidadDeTarjetasPendientesSegunPersona(persona));
    }

    @Test
    @DisplayName("trazabilidad horaria de tarjetas pendientes")
    void registroDeEntregaDeTarjetasPendientes() {
        Colaborador colaborador = new Colaborador("Pepito");
        ServicioEntregaTarjeta servicioEntregaTarjeta = new ServicioEntregaTarjeta();

        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1234"), new PersonaEnSituacionVulnerable("Juan1"));
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1233"), new PersonaEnSituacionVulnerable("Juan2"));
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1232"), new PersonaEnSituacionVulnerable("Juan3"));
        Assertions.assertEquals(3, servicioEntregaTarjeta.mostrarTarjetasPendientesDeColaborador(colaborador));
    }
    @Test
    @DisplayName("trazabilidad horaria de tarjetas pendiente cuando se entrego una tarjeta")
    void registroDeEntregaDeTarjetasEntregadas() {
        Colaborador colaborador = new Colaborador("Pepito");
        ServicioEntregaTarjeta servicioEntregaTarjeta = new ServicioEntregaTarjeta();
        var persona = new PersonaEnSituacionVulnerable("Juan3");
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1234"), new PersonaEnSituacionVulnerable("Juan1"));
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1233"), new PersonaEnSituacionVulnerable("Juan2"));
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1232"), persona);

        servicioEntregaTarjeta.entregarTarjeta(colaborador, persona);
        Assertions.assertEquals(2, servicioEntregaTarjeta.mostrarTarjetasPendientesDeColaborador(colaborador));
    }

    @Test
    @DisplayName("trazabilidad horaria de tarjetas entregada cuando se entrego una tarjeta")
    void registroDeEntregaDeTarjetasEntregadas2() {
        Colaborador colaborador = new Colaborador("Pepito");
        ServicioEntregaTarjeta servicioEntregaTarjeta = new ServicioEntregaTarjeta();
        var persona = new PersonaEnSituacionVulnerable("Juan3");
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1234"), new PersonaEnSituacionVulnerable("Juan1"));
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1233"), new PersonaEnSituacionVulnerable("Juan2"));
        servicioEntregaTarjeta.enviarTarjeta(colaborador, new Tarjeta("1232"), persona);

        servicioEntregaTarjeta.entregarTarjeta(colaborador, persona);
        Assertions.assertEquals(1, servicioEntregaTarjeta.mostrarTarjetasEntregadasDeColaborador(colaborador));
    }
}
