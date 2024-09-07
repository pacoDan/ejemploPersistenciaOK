package models.entities.Heladera;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Punto {

    public double latitud;
    public double longitud;

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public Punto(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Double.compare(punto.latitud, latitud) == 0 &&
                Double.compare(punto.longitud, longitud) == 0;
    }
    //para determinar si dos instancias de una clase son iguales en términos
    // de su contenido (valores de sus atributos) y no simplemente en
    // términos de su referencia en memoria.

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }//El método hashCode genera un valor hash para el objeto.


    public double distanciaA(Punto otroPunto) {
        final int R = 6371;
        double latDist = Math.toRadians(otroPunto.latitud - this.latitud);
        double lonDist = Math.toRadians(otroPunto.longitud - this.longitud);
        double a = Math.sin(latDist / 2) * Math.sin(latDist / 2)
                + Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(otroPunto.latitud))
                * Math.sin(lonDist / 2) * Math.sin(lonDist / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
    //Si dos objetos son iguales según equals, deben tener el mismo valor de hashCode


}