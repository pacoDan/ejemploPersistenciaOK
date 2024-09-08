package ColaboradorTests.CanjesTests;

import domain.Colaborador;
import domain.canjes.ProductoCanjeable;
import domain.puntajes.Oferta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanjeTest {
    @Test
    @DisplayName("canjeo 50mil puntos por una heladera de 20mil puntos")
    void unCanjeo() {
        Colaborador unColaborador = new Colaborador();
        unColaborador.setPuntaje(50000);
        ProductoCanjeable heladera = new ProductoCanjeable("heladera");
        Oferta heladeraDisponible = new Oferta(heladera,20000);
        assertTrue(unColaborador.puedeCanjear(heladeraDisponible));
    }
    @Test
    @DisplayName("tengo 50mil y despues de canjear heladera de 20mil tengo 30mil")
    void otroCanjeo() {
        Colaborador unColaborador = new Colaborador();
        unColaborador.setPuntaje(50000);
        ProductoCanjeable heladera = new ProductoCanjeable("heladera");
        Oferta heladeraDisponible = new Oferta(heladera,20000);
        unColaborador.canjear(heladeraDisponible);
        assertEquals(30000, unColaborador.getPuntajeActualReconocido());
    }
}
