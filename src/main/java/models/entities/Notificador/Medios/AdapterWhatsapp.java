package models.entities.Notificador.Medios;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import models.entities.Notificador.Notificacion;

public class AdapterWhatsapp implements AdapterNotificacionWhatsapp{

    public static final String ACCOUNT_SID = "ACc475ca4b1b341f18b662c197dfbef598";
    public static final  String AUTH_TOKEN = "ed9d08a2c7294e50adb4eb49e38a1cfb";
    public void notificar(Notificacion notificacion) {


        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+ notificacion.getReceptor().getDatosPersonales().getNumTelefono()),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                notificacion.getMensaje()).create();
        System.out.println(message.getSid());
        }
    }


