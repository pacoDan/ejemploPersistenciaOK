package Incidentes;

import models.entities.Heladera.Punto;

public class CalculadorDeDistancias {
    public static double calcularDistancia(Punto p1, Punto p2) {
        double dx = p1.getLatitud() - p2.getLatitud();
        double dy = p1.getLongitud() - p2.getLongitud();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
