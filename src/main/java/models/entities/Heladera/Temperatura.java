package models.entities.Heladera;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Temperatura {
    private Double valor;
    private LocalDateTime fechaYHoraIngresada;

    public Temperatura(Double valor ,LocalDateTime fechaYHoraIngresada) {
        this.valor = valor;
        this.fechaYHoraIngresada = fechaYHoraIngresada;
    }

    public LocalDateTime getFechaYHoraIngresada() {
        return fechaYHoraIngresada;
    }
}
