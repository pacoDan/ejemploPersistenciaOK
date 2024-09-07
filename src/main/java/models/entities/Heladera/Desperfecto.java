package models.entities.Heladera;
import domain.tecnicos.Tecnico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Desperfecto {
    private String descripcion;
  //  private Date fecha;
    private Tecnico tecnico;
    public Desperfecto(String descripcion/*, /*String fecha*/) {
        this.descripcion = descripcion;
    //    this.fecha = fecha;
    }
}//TODO
