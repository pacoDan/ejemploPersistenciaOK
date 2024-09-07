package models.entities.Heladera.Suscripcion.Tipo;

import domain.Colaborador;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.Punto;

import java.time.LocalDateTime;
import java.util.List;

public class RegistroSugerencia {

    private Punto punto;
    private Colaborador colaborador;
    private LocalDateTime fechaHora;
    private List<Heladera> heladerasSugeridas;

    public RegistroSugerencia(Punto punto, Colaborador colaborador, List<Heladera> heladerasSugeridas) {
        this.punto = punto;
        this.colaborador = colaborador;
        this.fechaHora = LocalDateTime.now();
        this.heladerasSugeridas = heladerasSugeridas;
    }
}
