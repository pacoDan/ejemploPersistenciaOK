package tarjetaColaboradoresTests;

import colaboraciones.trazabilidad.AccionIngresarViandas;
import domain.Colaborador;
import models.entities.Heladera.Heladera;
import models.entities.Vianda.Vianda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicios.ServicioEntregaDeVianda;

public class ColaboracionesHechasTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("se contabiliza la entrega de vianda")
    void auditoriaTarjeta() {
        Colaborador colaborador = new Colaborador();
        Vianda vianda = new Vianda("Una Vianda");
        Heladera heladera = new Heladera("Heladera 1");

        AccionIngresarViandas accionIngresarViandas = new AccionIngresarViandas();
        accionIngresarViandas.ingresarViandaARecibir(colaborador, vianda, heladera);
        int cantidadIngresos = accionIngresarViandas.cantidadIngresoDeViandas();
        Assertions.assertEquals(1, cantidadIngresos);
    }

    //    @Test
//    @DisplayName("la heladera espera la entrega de vianda")
//    void heladeraEsperaVianda() {
//        Colaborador colaborador = new Colaborador();
//        Vianda vianda = new Vianda("Una Vianda");
//        Heladera heladera = new Heladera("Heladera 1");
//        AccionIngresarViandas accionIngresarViandas = new AccionIngresarViandas();
//        accionIngresarViandas.ingresarViandaARecibir(colaborador,vianda,heladera);
//        Assertions.assertEquals(1, heladera.viandasARecibir().size());
//    }
    @Test
    @DisplayName("heladera espera vianda")
    void heladeraEsperaVianda() {
        Colaborador colaborador = new Colaborador();
        Vianda vianda = new Vianda("Una Vianda");
        Heladera heladera = new Heladera("Heladera 1");

        AccionIngresarViandas accionIngresarViandas = new AccionIngresarViandas();
        accionIngresarViandas.ingresarViandaARecibir(colaborador, vianda, heladera);
        int cantidadIngresos = accionIngresarViandas.cantidadIngresoDeViandas();

        ServicioEntregaDeVianda servicioEntregaDeViandas = new ServicioEntregaDeVianda();
        servicioEntregaDeViandas.entregarVianda(colaborador,vianda,  heladera);
        Assertions.assertEquals(1, servicioEntregaDeViandas.cantidadPendienteDeViandasDeHeladera(heladera));
    }
//    @Test
//    @DisplayName("cuando se entrega vianda se descontabiliza las pendiente y heladera se entera que se entrego una ")
//    void heladeraSeteaEntregaDeVianda() {
//        Colaborador colaborador = new Colaborador();
//        Vianda vianda = new Vianda("Una Vianda");
//        Heladera heladera = new Heladera("Heladera 1");
//
//        AccionIngresarViandas accionIngresarViandas = new AccionIngresarViandas();
//        accionIngresarViandas.ingresarViandaARecibir(colaborador, vianda, heladera);
//        int cantidadIngresos = accionIngresarViandas.cantidadIngresoDeViandas();
//
//        ServicioEntregaDeVianda servicioEntregaDeViandas = new ServicioEntregaDeVianda();
//        servicioEntregaDeViandas.entregarVianda(colaborador,vianda,  heladera);
//        Assertions.assertEquals(1, servicioEntregaDeViandas.cantidadPendienteDeViandasDeHeladera(heladera));
//    }
    
}
