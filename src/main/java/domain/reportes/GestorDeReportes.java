package domain.reportes;

import Incidentes.Incidente;
import Incidentes.TipoIncidente;
import colaboraciones.DonacionVianda.DonacionVianda;
import domain.PersonaFisica;
import models.entities.Heladera.Heladera;
import repositorios.RepositorioDonacionVianda;
import repositorios.RepositorioHeladera;
import repositorios.RepositorioIncidentes;
import repositorios.RepositorioPersonaFisica;

import java.util.ArrayList;
import java.util.List;

public class GestorDeReportes {
    RepositorioHeladera repoHeladeras = new RepositorioHeladera();
    RepositorioIncidentes repoIncidentes = new RepositorioIncidentes();
    RepositorioDonacionVianda repoDonacionesVianda = new RepositorioDonacionVianda();
    RepositorioPersonaFisica repoPersonasFisicas = new RepositorioPersonaFisica();

    public List<CantidadViandasHeladera> generarReporteViandasHeladera() {
        List<CantidadViandasHeladera> datosARetornar = new ArrayList<>();
        for (Heladera h : repoHeladeras.getHeladeras()) {
            CantidadViandasHeladera registro = new CantidadViandasHeladera();
            registro.setHeladera(h);
            registro.setViandasColocadas(h.getCantidadViandasColocadas());
            registro.setViandasRetiradas(h.getCantidadViandasRetiradas());
            datosARetornar.add(registro);
        }
        return datosARetornar;
    }

    public List<FallasDeHeladera> generarReporteFallasHeladera() {
        List<FallasDeHeladera> datosARetornar = new ArrayList<>();
        FallasDeHeladera registro = new FallasDeHeladera();
        for (Heladera h : repoHeladeras.getHeladeras()) {
            for (Incidente i : repoIncidentes.getIncidentes()) {
                if (i.getHeladera().equals(h) && i.getTipoIncidente().equals(TipoIncidente.FALLA_TECNICA)) {
                    registro.setHeladera(h);
                    registro.setCantidadFallas(registro.getCantidadFallas() + 1);
                }
            }
            datosARetornar.add(registro);
        }
        return datosARetornar;
    }

    public List<ViandasPorColaborador> generarReporteDonacionViandasColaborador() {
        List<ViandasPorColaborador> datosARetornar = new ArrayList<>();
        ViandasPorColaborador registro = new ViandasPorColaborador();
        for(PersonaFisica pf : repoPersonasFisicas.getPersonasFisicas()){
            int contador = 0;
            for(DonacionVianda d : repoDonacionesVianda.getDonacionesVianda()){
                if(d.getColaborador().getFisica().equals(pf)) {
                    contador += 1;
                }
            }
            registro.setColaborador(pf);
            registro.setCantidadViandasDonadas(contador);
            datosARetornar.add(registro);
        }
        return datosARetornar;
    }


}