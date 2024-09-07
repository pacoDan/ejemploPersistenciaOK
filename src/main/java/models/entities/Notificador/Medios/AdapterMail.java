package models.entities.Notificador.Medios;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import models.entities.Notificador.Notificacion;

import java.util.Properties;

public class AdapterMail implements AdapterNotificacionMail{

    static String remitente = "congelandoelhambre@gmail.com";

    public void notificar(Notificacion notificacion){
        String destinatario = notificacion.getReceptor().getDatosPersonales().getMail();

        if (destinatario == null || destinatario.isEmpty() || !isValidEmail(destinatario)) {
            throw new RuntimeException("Dirección de correo del destinatario no es válida: " + destinatario);
        }

        try {
            Message message = new MimeMessage(getEmailSession());
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Alerta de suscripcion de heladera");
            message.setText(notificacion.getMensaje());

            Transport.send(message);

            System.out.println("Correo enviado exitosamente a " + destinatario);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties getGmailProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return prop;
    }

    private static Session getEmailSession() {
        return Session.getInstance(getGmailProperties(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, "fwqwawiiukmxukwz");
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
