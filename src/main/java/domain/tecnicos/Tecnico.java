package domain.tecnicos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tecnico {
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String cuil;
    private String medioDeContacto;
    private Area areaDeCobertura;
    private String numTelefono;

    public Tecnico(String nombre, String apellido, String tipoDocumento, String numeroDocumento, String cuil, String medioDeContacto, Area areaDeCobertura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.cuil = cuil;
        this.medioDeContacto = medioDeContacto;
        this.areaDeCobertura = areaDeCobertura;
    }

    public String getNombreCompleto(){
        return this.nombre + this.apellido;
    }
}
