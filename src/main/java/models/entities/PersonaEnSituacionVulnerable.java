package models.entities;

import lombok.Getter;
import lombok.Setter;
import models.entities.Direccion.Direccion;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class PersonaEnSituacionVulnerable {
    private List<PersonaEnSituacionVulnerable> menoresACargo;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Date fechaRegistro;
    private Direccion domicilio;
    private String nroDocumento;
    private int cantMenores;
    private Tarjeta tarjeta;

    public PersonaEnSituacionVulnerable(){
        this.menoresACargo = new ArrayList<>();
    }

    public PersonaEnSituacionVulnerable(String nombre) {
        this();
        this.nombre = nombre;
    }

    public boolean esMenor(){
        LocalDate fechaActual = LocalDate.now();
        return (Period.between(this.getFechaNacimiento() , fechaActual).getYears()<18);
    }

    public List<PersonaEnSituacionVulnerable> getMenoresActualizados(){
        List<PersonaEnSituacionVulnerable> nuevaLista = new ArrayList<>();
        for(PersonaEnSituacionVulnerable p : this.getMenoresACargo()){
            if(p.esMenor()){
                nuevaLista.add(p);
            }
        }
        return nuevaLista;
    }


}
