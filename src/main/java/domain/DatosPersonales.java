package domain;

import lombok.Getter;
import lombok.Setter;
import models.entities.Direccion.Direccion;

import java.util.Date;

@Getter
@Setter
//@Entity
//@Table(name = "datos_personales")
public class DatosPersonales {
    private String nombre;
    private String apellido;
    private String medioDeContacto;
    private Date fechaNacimiento;
    private Direccion direccion;
    private String mail;
    private String documento;
    private String tipoDoc;

    private String numTelefono;


    public DatosPersonales(String tipoDoc, String documento, String nombre, String apellido, String mail, String numTelefono) {
        this.apellido = apellido;
        this.documento = documento;
        this.tipoDoc =  tipoDoc;
        this.nombre = nombre;
        this.mail = mail;
        this.numTelefono = numTelefono;
    }

    public DatosPersonales(String nombre) {
        this.nombre = nombre;
    }

    public DatosPersonales() {
        
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
