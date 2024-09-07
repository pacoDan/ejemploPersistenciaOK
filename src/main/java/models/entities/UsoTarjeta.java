package models.entities;


import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsoTarjeta {
    private Tarjeta tarjeta;
    private Heladera heladeraDondeSeUso;
    private LocalDateTime fechaYHoraDeUso;

    public UsoTarjeta(Tarjeta tarjeta, LocalDateTime fechaYHoraDeUso) {
        this.tarjeta = tarjeta;
        this.fechaYHoraDeUso = fechaYHoraDeUso;
    }

    public UsoTarjeta(Tarjeta tarjeta, Heladera heladeraDondeSeUso, LocalDateTime horaDeUso) {
        this.tarjeta = tarjeta;
        this.heladeraDondeSeUso = heladeraDondeSeUso;
        this.fechaYHoraDeUso = horaDeUso;
    }
}
