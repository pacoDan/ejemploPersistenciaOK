package servicios;

import domain.Colaborador;
import models.entities.PersonaEnSituacionVulnerable;
import models.entities.Tarjeta;
import repositorios.RepositorioTarjetasEntregadas;
import repositorios.RepositoryTarjetasPendientesAEntregar;

public class ServicioEntregaTarjeta {
    RepositoryTarjetasPendientesAEntregar repositoryTarjetasPendientesAEntregar;
    RepositorioTarjetasEntregadas repositorioTarjetasEntregadas;
    public ServicioEntregaTarjeta() {
        this.repositoryTarjetasPendientesAEntregar = new RepositoryTarjetasPendientesAEntregar();
        this.repositorioTarjetasEntregadas = new RepositorioTarjetasEntregadas();
    }

    public void enviarTarjeta(Colaborador colaborador, Tarjeta tarjeta, PersonaEnSituacionVulnerable persona) {
//        if(this.repositoryTarjetasPendientesAEntregar == null)
//            this.repositoryTarjetasPendientesAEntregar = new RepositoryTarjetasPendientesAEntregar();
        this.repositoryTarjetasPendientesAEntregar.add(colaborador, tarjeta, persona);
    }
    public int cantidadDeTarjetasPendienteAEntregar() {
        return this.repositoryTarjetasPendientesAEntregar.size();
    }

    public int cantidadDeTarjetasPendientesSegunPersona(PersonaEnSituacionVulnerable persona) {
        return this.repositoryTarjetasPendientesAEntregar.countByPersona(persona);
    }

    public int mostrarTarjetasPendientesDeColaborador(Colaborador colaborador) {
        int cantidad= repositoryTarjetasPendientesAEntregar.countByColaborador(colaborador);
        repositoryTarjetasPendientesAEntregar.selectEntregaByColaborador(colaborador).forEach(System.out::println);
        return cantidad;
    }

    public void entregarTarjeta(Colaborador colaborador, PersonaEnSituacionVulnerable persona) {
        var tarjeta = this.repositoryTarjetasPendientesAEntregar.quitar(colaborador, persona);
        this.repositorioTarjetasEntregadas.add(colaborador,persona,tarjeta);
    }

    public int mostrarTarjetasEntregadasDeColaborador(Colaborador colaborador) {
        int cantidad= repositorioTarjetasEntregadas.countByColaborador(colaborador);
        this.repositorioTarjetasEntregadas.selectEntregaByColaborador(colaborador).forEach(System.out::println);
        return cantidad;
    }
}
