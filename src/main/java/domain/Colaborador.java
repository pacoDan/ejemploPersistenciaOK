package domain;

import colaboraciones.DistribuirVianda.DistribuirVianda;
import domain.puntajes.Colaboracion;
import domain.puntajes.Oferta;
import domain.puntajes.ReconocimientoColaborador;
import lombok.Getter;
import lombok.Setter;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.MotivoSolicitud;
import models.entities.Heladera.Suscripcion.Suscripcion;
import models.entities.Heladera.Suscripcion.Tipo.TipoSuscripcion;
import models.entities.Notificador.EstrategiaNotificacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
//@Entity
//@Table(name = "colaborador")
public class Colaborador {
//    @Id
//    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Transient
    private DatosPersonales datosPersonales;
//    @Transient
    private Usuario usuario;
//    @Transient
    private PersonaFisica fisica;
//    @Transient
    private PersonaJuridica juridica;
//    @Transient
    private String tipoColaborador;
//    @Transient
    private List<Colaboracion> colaboraciones;
//    @Transient
    private ReconocimientoColaborador reconocimiento;
//    @Transient
    private double puntajeActualReconocido;
//    @Transient
    private List<Oferta> ofertasCanjeadas;
//    @Transient
    private List<Suscripcion> suscripciones;

    public Colaborador(String nombre) {
        this.datosPersonales = new DatosPersonales(nombre);
    }


    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Colaborador(DatosPersonales datosPersonales, Usuario usuario) {
        this.datosPersonales = datosPersonales;
        this.usuario = usuario;
//        this.tipoColaborador = tipoColaborador;
        this.puntajeActualReconocido =0;
        this.ofertasCanjeadas=new ArrayList<Oferta>();
        this.colaboraciones = new ArrayList<>();
        this.suscripciones = new ArrayList<>();
    }
    public Colaborador() {
        this.reconocimiento= new ReconocimientoColaborador();
        this.colaboraciones= new ArrayList<Colaboracion>();
        this.puntajeActualReconocido =0;
        this.ofertasCanjeadas=new ArrayList<Oferta>();
    }
    public Colaborador(PersonaJuridica juridica) {
        this.juridica = juridica;
    }

    public Colaborador(PersonaFisica fisica) {
        this.fisica =fisica;
    }


    public double calcularPuntajeActualReconocido(){
        this.puntajeActualReconocido = reconocimiento.calcularPuntos(this.colaboraciones);
        return this.puntajeActualReconocido;
    }

    public void colaborar(Colaboracion unaColaboracion) {
        this.colaboraciones.add(unaColaboracion);
    }

    public void setPuntaje(int puntos) {
        this.puntajeActualReconocido =puntos;
    }

    public boolean puedeCanjear(Oferta ofertaCanjeable) {
        return this.puntajeActualReconocido>=ofertaCanjeable.puntosRequeridos();
    }

    public void canjear(Oferta ofertaACanjear) {
        if(this.puedeCanjear(ofertaACanjear)){
            this.puntajeActualReconocido-=ofertaACanjear.puntosRequeridos();
            ofertasCanjeadas.add(ofertaACanjear);
            ofertaACanjear.FueCanjeado();
        }
        // else y tirar excepcion de que no puede canjear
    }
    public void agregarColaboracion(DistribuirVianda distribuirVianda) {
        this.colaboraciones.add(new Colaboracion(distribuirVianda));
        distribuirVianda.ActualizarStock();
    }

    public void suscribirseAHeladera(Heladera heladera, TipoSuscripcion tipo, EstrategiaNotificacion medio) {
        Suscripcion suscripcion = new Suscripcion(tipo,this, medio);
        heladera.agregarSuscripcion(suscripcion);
        this.suscripciones.add(suscripcion);
    }


    //TODO: Terminar metodo
    public void solicitarAbrirHeladera(Heladera heladera, MotivoSolicitud motivo, Date fechaSolicitada, Colaborador colaborador) {
        heladera.realizarSolicitud(heladera, motivo, fechaSolicitada);
    }



    public String getNombre() {
        return this.datosPersonales.getNombre();
    }
}
