package models.entities.Heladera;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Distancia {
    private Double Valor;
    private LocalDateTime fechaYHoraRegistrada;

    public Distancia(Double valor, LocalDateTime fechaYHoraRegistrada) {
        Valor = valor;
        this.fechaYHoraRegistrada = fechaYHoraRegistrada;
    }
}
