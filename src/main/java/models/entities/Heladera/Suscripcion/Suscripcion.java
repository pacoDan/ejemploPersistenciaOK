package models.entities.Heladera.Suscripcion;

import domain.Colaborador;
import models.entities.Heladera.Heladera;
import models.entities.Heladera.Suscripcion.Tipo.HeladeraSufrioDesperfecto;
import models.entities.Heladera.Suscripcion.Tipo.SugeridorDeHeladeras;
import models.entities.Heladera.Suscripcion.Tipo.TipoSuscripcion;
import models.entities.Notificador.EstrategiaNotificacion;

import java.time.LocalDateTime;

public class Suscripcion {
    private TipoSuscripcion tipo;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaaBaja;
    private Colaborador colaboradorSuscripto;

    private SugeridorDeHeladeras sugeridor;

    private EstrategiaNotificacion medio;


    public TipoSuscripcion getTipo() {
        return tipo;
    }

    public Colaborador getColaboradorSuscripto() {
        return colaboradorSuscripto;
    }

    public Suscripcion(TipoSuscripcion tipo, Colaborador colaboradorSuscripto, EstrategiaNotificacion medio) {
        this.tipo = tipo;
        this.colaboradorSuscripto = colaboradorSuscripto;
        this.medio = medio;
    }


    public void notificarDesperfecto(int valor, Heladera heladera){
        tipo.notificar(valor,medio,colaboradorSuscripto);
        sugeridor.sugerirHeladerasPara(heladera.getUbicacion(), colaboradorSuscripto, valor);
    }

    public void notificar(int valor){
        if(!(tipo instanceof HeladeraSufrioDesperfecto)){
        tipo.notificar(valor,medio,colaboradorSuscripto);}
    }



}



