package models.entities.Heladera;

import Incidentes.Incidente;
import domain.Colaborador;
import lombok.Getter;
import lombok.Setter;
import models.entities.Direccion.Direccion;
import models.entities.Heladera.Suscripcion.Suscripcion;
import models.entities.Vianda.Vianda;
import servicios.ServiceViandas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Heladera {

    private Punto ubicacion;
    private Direccion direccion;
    private String nombre;
    private List<Vianda> viandas;
    private int capacidad;
    private Date fechaDeInicio;


    private ValorEstado valorEstado;
    private Estado estado;

    private List<Desperfecto> desperfectos;
    private Temperatura temperaturaMaxima;
    private Temperatura temperaturaMinima;
    private SensorTemperatura sensorDeTemperatura;
    private SensorMovimiento sensorDeMovimiento;

    private List<SolicitudApertura> solicitudesAperturas;

    private List<Incidente> incidentes;
    private Temperatura ultTemperatura;
    private Long id;



    private List<Suscripcion> suscripciones;
    private int cantidadViandasColocadas;
    private int cantidadViandasRetiradas;

    public Heladera(Punto ubicacion, Direccion direccion, String nombre, List<Vianda> viandas, int capacidad, Date fechaDeInicio, Estado estado, List<Desperfecto> desperfectos, Temperatura temperaturaMaxima, Temperatura temperaturaMinima, SensorTemperatura sensorDeTemperatura, SensorMovimiento sensorDeMovimiento, List<Suscripcion> suscripciones) {
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.nombre = nombre;
        this.viandas = viandas;
        this.capacidad = capacidad;
        this.fechaDeInicio = fechaDeInicio;
        this.estado = estado;
        this.desperfectos = desperfectos;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
        this.sensorDeTemperatura = sensorDeTemperatura;
        this.sensorDeMovimiento = sensorDeMovimiento;
        this.suscripciones = suscripciones;
    }


    public Heladera(List<Vianda> viandas, int i, List<Desperfecto> desperfectos, List<Suscripcion> suscripciones) {
        this.viandas = viandas;
        this.capacidad = i;
        this.desperfectos = desperfectos;
        this.suscripciones = suscripciones;
    }

    public Heladera(){
        this.cantidadViandasColocadas = 0;
        this.cantidadViandasRetiradas = 0;
    }

    public Heladera(String nombre) {
        this.nombre = nombre;
    }

    public void agregarVianda(Vianda vianda) {
        viandas.add(vianda);
        notificarSuscripciones(viandas.size());
    }

    public void quitarVianda(Vianda vianda) {
        viandas.remove(vianda);
        notificarSuscripciones(viandas.size());
    }


    public void agregarDesperfecto(Desperfecto desperfecto) {
        desperfectos.add(desperfecto);
        notificarDesperfecto(viandas.size());
    }


    public void notificarSuscripciones(int cantidadViandas){
        this.suscripciones.forEach(s -> s.notificar(cantidadViandas));
    }

    public void notificarDesperfecto(int cantidadViandas) {
        this.suscripciones.forEach(s -> s.notificarDesperfecto(cantidadViandas, this));
    }

    public void agregarSuscripcion(Suscripcion suscripcion) {
        suscripciones.add(suscripcion);
    }

    public int getCapacidadDisponible() {
        return capacidad - viandas.size();
    }






    public ArrayList<Vianda> viandasARecibir() {
        ServiceViandas viandasServicio = new ServiceViandas();
        return viandasServicio.cantidadDeViandasARecibirDeHeladera(this);
    }

    public boolean equals(Heladera obj) {
        return obj.nombre==this.nombre;
    }

    public void agregarViandaARecibir(Vianda vianda) {
        vianda.setHeladera(this);
    }


    public boolean verificarPermiso(Colaborador colaborador, Heladera heladera, Date fechaSolicitada) {
        for(SolicitudApertura solicitud : solicitudesAperturas){
            if(verificarSolicitud(solicitud, colaborador, heladera, fechaSolicitada)) {
                return true;
            };
        }
        return false;
    }

    public boolean verificarSolicitud(SolicitudApertura solicitud, Colaborador colaborador, Heladera heladera, Date fechaSolicitada) {
        return solicitud.getColaborador().equals(colaborador) && solicitud.getHeladera().equals(heladera) && solicitud.getFechaApertura().equals(fechaSolicitada);
    }

    public void realizarSolicitud(Heladera heladera, MotivoSolicitud motivo, Date fechaSolicitada) {

    }


    public void marcarComoInactiva(){
        this.valorEstado = ValorEstado.INACTIVA;

    }
    public void agregarIncidente(Incidente incidente){
        this.incidentes.add(incidente);
    }


}
