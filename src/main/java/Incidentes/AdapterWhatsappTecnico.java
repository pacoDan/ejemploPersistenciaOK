package Incidentes;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class AdapterWhatsappTecnico implements AdapterNotificacionWhatsappTecnico{

        public static final String ACCOUNT_SID = "AC75fff862d879700e5aff65a778042b21";
        public static final  String AUTH_TOKEN = "ed9d08a2c7294e50adb4eb49e38a1cfb";
        public void notificar(NotificacionTecnico notificacion) {


            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:"+ notificacion.getReceptor().getNumTelefono()),
                    new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                    notificacion.getMensaje()).create();
            System.out.println(message.getSid());
        }

}
