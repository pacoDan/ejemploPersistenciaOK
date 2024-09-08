package Incidentes;

import domain.reportes.CantidadViandasHeladera;
import domain.reportes.FallasDeHeladera;
import domain.reportes.GestorDeReportes;
import domain.reportes.ViandasPorColaborador;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CronJob {

    private ServicioTemperatura temperaturaService;
    private GestorDeReportes gestorDeReportes;

    @Scheduled(fixedRate = 300000) // Cada 5 minutos
    public void verificarTemperaturas() {
        temperaturaService.verificarUltimasTemperaturas();
    }

    @Scheduled(cron = "0 0 10 ? * MON") // Semanalmente los Lunes
    public void generarReportes(){
        List<FallasDeHeladera> reporteFallas = this.gestorDeReportes.generarReporteFallasHeladera();
        List<CantidadViandasHeladera> reporteViandasHeladera = this.gestorDeReportes.generarReporteViandasHeladera();
        List<ViandasPorColaborador> reporteViandasDonadas = this.gestorDeReportes.generarReporteDonacionViandasColaborador();
    }

}
