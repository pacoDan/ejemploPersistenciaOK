package Incidentes;

import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.Temperatura;
import org.jvnet.hk2.annotations.Service;
import repositorios.RepositorioHeladera;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Service
public class ServicioTemperatura {


    private RepositorioHeladera repositorioHeladera;


    public void verificarUltimasTemperaturas() {
        List<Heladera> heladeras = repositorioHeladera.findAll();
        for (Heladera heladera : heladeras) {
            Temperatura ultimaTemperatura = heladera.getUltTemperatura();
            if (ultimaTemperatura != null) {
                Duration duration = Duration.between(ultimaTemperatura.getFechaYHoraIngresada(), LocalDateTime.now());
                long diffInMinutes = duration.toMinutes();
                if (diffInMinutes > 5) {
                    Alerta alerta = new Alerta(TipoAlerta.FALLA_CONEXION);
                    alerta.evaluar(heladera);
                }
            }
        }
    }
}

