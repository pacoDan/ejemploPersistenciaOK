package models.entities.Heladera.Suscripcion.Tipo;

import domain.Colaborador;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.Punto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugeridorDeHeladeras {

    private List<Heladera> heladeras;
    private double umbralDistancia; // Parametrizable

    private List<RegistroSugerencia> registrosSugerencias;

    public SugeridorDeHeladeras(List<Heladera> heladeras, double umbralDistancia) {
        this.heladeras = heladeras;
        this.umbralDistancia = umbralDistancia;
        this.registrosSugerencias = new ArrayList<>();
    }

    public List<Heladera> sugerirHeladerasPara(Punto punto, Colaborador colaborador, int cantidadViandas) {
        List<Heladera> heladerasSugeridas = heladeras.stream()
                .filter(heladera -> heladera.getCapacidadDisponible() >= cantidadViandas)
                .filter(heladera -> calcularDistancia(punto, heladera.getUbicacion()) <= umbralDistancia)
                .sorted(Comparator.comparingDouble(heladera -> calcularDistancia(punto, heladera.getUbicacion())))
                .collect(Collectors.toList());

        registrarSugerencia(punto, colaborador, heladerasSugeridas);

        return heladerasSugeridas;
    }

    private double calcularDistancia(Punto direccion1, Punto direccion2) {
        double lat1 = direccion1.getLatitud();
        double lon1 = direccion1.getLongitud();
        double lat2 = direccion2.getLatitud();
        double lon2 = direccion2.getLongitud();

        final int R = 6371; // Radio de la tierra en km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = R * c; // convertir a km

        return distancia;
    }

    private void registrarSugerencia(Punto punto, Colaborador colaborador, List<Heladera> heladerasSugeridas) {
        RegistroSugerencia registro = new RegistroSugerencia(punto, colaborador, heladerasSugeridas);
        registrosSugerencias.add(registro);
    }

}