package repositorios;

import domain.Colaborador;
import models.entities.PersonaEnSituacionVulnerable;
import models.entities.Tarjeta;

import java.util.ArrayList;
import java.util.Date;

public class RepositorioTarjetasEntregadas {
    public  ArrayList<TarjetaEntregada> repoTarjetasEntregadas;

    public void add(Colaborador colaborador, PersonaEnSituacionVulnerable persona, RepositoryTarjetasPendientesAEntregar.EntregaDeTarjeta tarjeta) {
        TarjetaEntregada tarjetaEntregada = new TarjetaEntregada(colaborador, tarjeta.tarjeta, persona);
        tarjetaEntregada.fechaSalidaEnvio = tarjeta.fechaSalidaEnvio;
        tarjetaEntregada.fechaDeEntrega = new Date();
        this.repoTarjetasEntregadas.add(tarjetaEntregada);
    }

    public int countByColaborador(Colaborador colaborador) {
        int i = 0;
        for (TarjetaEntregada tarjetaEntregada : this.repoTarjetasEntregadas) {
            if (tarjetaEntregada.colaborador.equals(colaborador)) {
                i++;
            }
        }
        return i;
    }

    public ArrayList<TarjetaEntregada> selectEntregaByColaborador(Colaborador colaborador) {
        ArrayList<TarjetaEntregada> tarjetasEntregadas = new ArrayList<TarjetaEntregada>();
        for (TarjetaEntregada tarjetaEntregada : this.repoTarjetasEntregadas) {
            if (tarjetaEntregada.colaborador.equals(colaborador)) {
                tarjetasEntregadas.add(tarjetaEntregada);
            }
        }
        return tarjetasEntregadas;
    }

    public static class TarjetaEntregada {
        public Colaborador colaborador;
        public Tarjeta tarjeta;
        public PersonaEnSituacionVulnerable persona;
        Date fechaSalidaEnvio;
        Date fechaDeEntrega;

        public TarjetaEntregada(Colaborador colaborador, Tarjeta tarjeta, PersonaEnSituacionVulnerable persona) {
            this.colaborador = colaborador;
            this.tarjeta = tarjeta;
            this.persona = persona;
//        this.fechaSalidaEnvio
            this.fechaDeEntrega = new Date();
        }

        @Override
        public String toString() {
            return "Colaborador: " + colaborador.getNombre() + " con tarjeta " + tarjeta.getCodigoAlfaNumerico() + " para persona vulnerable " + persona.getNombre() + " fecha de salida para entrega " + fechaSalidaEnvio.toString()+ " fecha entrega:"+fechaDeEntrega.toString();
        }
    }

    public RepositorioTarjetasEntregadas() {
        this.repoTarjetasEntregadas = new ArrayList<TarjetaEntregada>();
    }

    public void add(RepositoryTarjetasPendientesAEntregar.EntregaDeTarjeta entregado) {
        TarjetaEntregada tarjetaEntregada = new TarjetaEntregada(entregado.colaborador, entregado.tarjeta, entregado.persona);
        tarjetaEntregada.fechaSalidaEnvio = entregado.fechaSalidaEnvio;
        tarjetaEntregada.fechaDeEntrega = new Date();
        this.repoTarjetasEntregadas.add(tarjetaEntregada);
    }

}
