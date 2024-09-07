package models.entities;

import domain.PersonaFisica;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Tarjeta {
    private String codigoAlfaNumerico;
    private int cantidadViandasDisponiblesPorDia;
    private Date fechaDeCreacion;
    private Date fechaDeBaja;
    private boolean activa;
    private PersonaEnSituacionVulnerable propietario;
    private PersonaFisica colaboradorQueLaDioDeAlta;
    private List<UsoTarjeta> usos;

    public Tarjeta(PersonaEnSituacionVulnerable propietario) {
        this.propietario = propietario;
        this.usos = new ArrayList<>();
    }

    public Tarjeta(String codigoAlfaNumerico, Date fechaDeCreacion, Date fechaDeBaja, boolean activa, PersonaEnSituacionVulnerable propietario, PersonaFisica colaboradorQueLaDioDeAlta) {
        this.codigoAlfaNumerico = codigoAlfaNumerico;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeBaja = fechaDeBaja;
        this.activa = activa;
        this.propietario = propietario;
        this.colaboradorQueLaDioDeAlta = colaboradorQueLaDioDeAlta;
    }

    public Tarjeta() {
        this.fechaDeCreacion = new Date();
        this.activa = false;
        this.usos = new ArrayList<UsoTarjeta>();
    }

    public Tarjeta(String id) {
        this.codigoAlfaNumerico = id;
    }

    public int getCantidadViandasDisponiblesPorDia() {
        return 4 + (2 * this.getPropietario().getMenoresActualizados().size());
    }

    public List<UsoTarjeta> getUsosDiarios() {
        List<UsoTarjeta> nuevaListaUsos = new ArrayList<>();
        for (UsoTarjeta u : this.getUsos()) {
            if (u.getFechaYHoraDeUso().toLocalDate().equals(LocalDate.now())) {
                nuevaListaUsos.add(u);
            }
        }
        return nuevaListaUsos;
    }

    public boolean puedeUsarse() {
        return this.getUsosDiarios().size() < this.getCantidadViandasDisponiblesPorDia();
    }


//    public void mostrarInformacionDeTarjeta() {
////        System.out.println("Tarjeta: " + this.getCodigoAlfaNumerico());
//        System.out.print("Fecha de creacion: " + this.getFechaDeCreacion());
//        System.out.print("; Activa: " + this.isActiva());
//        System.out.println("; Beneficiario: " + this.getPropietario().getNombre());
////        System.out.println("; Cantidad de viandas disponibles para entregar: " + this.getCantidadViandasDisponiblesPorDia());
//    }
}
