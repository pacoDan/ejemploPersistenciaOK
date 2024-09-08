package Incidentes;

import domain.tecnicos.Tecnico;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.Punto;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaAsignacionPorDistancia implements EstrategiaAsignacion{
    @Override
    public List<Tecnico> asignarTecnico(List<Tecnico> tecnicos, Heladera heladera) {
        List<Tecnico> tecnicosCerca = new ArrayList<>();
        Punto ubicacionIncidente = heladera.getUbicacion();
        Tecnico tecnicoMasCercano = null;
        double menorDistancia = Double.MAX_VALUE;

        for (Tecnico tecnico : tecnicos) {
            double distancia = CalculadorDeDistancias.calcularDistancia(tecnico.getAreaDeCobertura().getCentro(), ubicacionIncidente);
            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                tecnicoMasCercano = tecnico;
            }
            if(distancia == menorDistancia){
                tecnicosCerca.add(tecnico);
            }
        }
        tecnicosCerca.add(tecnicoMasCercano);

        return tecnicosCerca;
    }
}
