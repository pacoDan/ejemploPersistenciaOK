package models.entities.Direccion;

import lombok.Setter;

@Setter
public class Direccion {
    String calle;
    Integer numero;
   // Localidad localidad;
     public Direccion (String calle, Integer numero/*, Localidad localidad*/){
         this.calle = calle;
     //    this.localidad = localidad;
         this.numero = numero;
     }

    public String getCalle() {
        return calle;
    }


}
