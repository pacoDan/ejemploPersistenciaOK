package testAPI;

import colaboraciones.HacerseCargoDeHeladera.AdapterReconmendadorDePuntosIdeales;
import colaboraciones.HacerseCargoDeHeladera.ReconmendadorDePuntosIdealesAPI;
import models.entities.Heladera.Punto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestAPI {
    private AdapterReconmendadorDePuntosIdeales apiAdapter;

    @BeforeEach
    public void setUp() {
        apiAdapter = new ReconmendadorDePuntosIdealesAPI();
    }

    @Test
    public void testConocerPuntosIdeales() {
        Punto puntoInicial = new Punto(-34.603722, -58.381592);
        double radio = 1.0;

        List<Punto> puntosIdeales = apiAdapter.obtenerPuntosColocacion(puntoInicial, radio);


        for (Punto punto : puntosIdeales) {
            System.out.println("Punto: Latitud " + punto.getLatitud() + ", Longitud " + punto.getLongitud());
        }
    }
}
