package models.entities.Heladera;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Estado {
    private ValorEstado valor;
    private LocalDateTime fecha;
    private String motivo;

    public Estado(ValorEstado valor, LocalDateTime fecha, String motivo) {
        this.valor = valor;
        this.fecha = fecha;
        this.motivo = motivo;
    }
}
