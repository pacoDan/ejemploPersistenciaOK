package repositorios;

import domain.Colaborador;
import models.entities.PersonaEnSituacionVulnerable;
import models.entities.Tarjeta;

import java.util.ArrayList;
import java.util.Date;

public class RepositoryTarjetasPendientesAEntregar
{
    public ArrayList<EntregaDeTarjeta> tarjetasPendientesAEntregar;
    public  class EntregaDeTarjeta
    {
        public Colaborador colaborador;
        public Tarjeta tarjeta;
        public PersonaEnSituacionVulnerable persona;
        Date fechaSalidaEnvio;
        Date fechaDeEntrega;
        public EntregaDeTarjeta(Colaborador colaborador, Tarjeta tarjeta, PersonaEnSituacionVulnerable persona) {
            this.colaborador = colaborador;
            this.tarjeta = tarjeta;
            this.persona = persona;
            this.fechaSalidaEnvio = new Date();
        }

        @Override
        public String toString() {
            return "Colaborador: "+ colaborador.getNombre() + " con tarjeta " + tarjeta.getCodigoAlfaNumerico() + " para persona vulnerable " + persona.getNombre() + " fecha de salida para entrega "+fechaSalidaEnvio.toString();
        }
    }
    public void add(Colaborador colaborador, Tarjeta tarjeta, PersonaEnSituacionVulnerable persona) {
        this.tarjetasPendientesAEntregar.add(new EntregaDeTarjeta(colaborador,tarjeta,persona));
    }

    public int countByPersona(PersonaEnSituacionVulnerable persona) {
        return (int) this.tarjetasPendientesAEntregar.stream().filter(entregaDeTarjeta -> entregaDeTarjeta.persona.equals(persona)).count();
    }

    public int countByColaborador(Colaborador colaborador) {
        return (int) this.tarjetasPendientesAEntregar.stream().filter(entregaDeTarjeta -> entregaDeTarjeta.colaborador.equals(colaborador)).count();
    }

    public RepositoryTarjetasPendientesAEntregar() {
        this.tarjetasPendientesAEntregar= new ArrayList<EntregaDeTarjeta>();
    }

    public int size() {
        return this.tarjetasPendientesAEntregar.size();
    }

    public ArrayList<EntregaDeTarjeta> selectEntregaByColaborador(Colaborador colaborador) {
        var _entregas= new ArrayList<EntregaDeTarjeta>();
        for (EntregaDeTarjeta entregaDeTarjeta : this.tarjetasPendientesAEntregar) {
            if(entregaDeTarjeta.colaborador.equals(colaborador))
                _entregas.add(entregaDeTarjeta);
        }
        return _entregas;
    }
    public EntregaDeTarjeta quitar(Colaborador colaborador, PersonaEnSituacionVulnerable persona) {
        EntregaDeTarjeta entrega;
        entrega = this.tarjetasPendientesAEntregar.stream().filter(entregaDeTarjeta -> entregaDeTarjeta.colaborador.equals(colaborador) && entregaDeTarjeta.persona.equals(persona)).findFirst().get();
        this.tarjetasPendientesAEntregar.remove(entrega);
        return entrega;
    }
}
