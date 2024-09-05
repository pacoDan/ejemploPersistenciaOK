package converters;

import models.entities.mediosDeNotificacion.EmailSender;
import models.entities.mediosDeNotificacion.IMedioDeNotificacion;
import models.entities.mediosDeNotificacion.WPPSender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MedioDeNotificacionAttributeConverter implements AttributeConverter<IMedioDeNotificacion, String> {

    @Override
    public String convertToDatabaseColumn(IMedioDeNotificacion iMedioDeNotificacion) {
        if(iMedioDeNotificacion == null) {
            return null;
        }

        String medioDeNotificacion = "";

        if(iMedioDeNotificacion instanceof WPPSender) {
            medioDeNotificacion = "WPP";
        }
        else if (iMedioDeNotificacion instanceof EmailSender) {
            medioDeNotificacion = "EMAIL";
        }

        return medioDeNotificacion;
    }

    @Override
    public IMedioDeNotificacion convertToEntityAttribute(String s) {
        if(s == null) {
            return null;
        }

        IMedioDeNotificacion iMedioDeNotificacion;

        switch (s) {
            case "WPP": iMedioDeNotificacion = new WPPSender(); break;
            case "EMAIL": iMedioDeNotificacion = new EmailSender(); break;
            default: iMedioDeNotificacion = null;
        }
        return iMedioDeNotificacion;
    }
}
