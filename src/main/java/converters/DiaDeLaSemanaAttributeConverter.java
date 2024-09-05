package converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.DayOfWeek;

@Converter(autoApply = true)
public class DiaDeLaSemanaAttributeConverter implements AttributeConverter<DayOfWeek, String> {

    @Override
    public String convertToDatabaseColumn(DayOfWeek dayOfWeek) {
        String dia;

        switch (dayOfWeek) {
            case MONDAY -> dia = "Lunes";
            default ->  dia = "";
        }

        return dia;
    }

    @Override
    public DayOfWeek convertToEntityAttribute(String s) {
        if(s == null || s.equals(""))
            return null;


        DayOfWeek dia;

        switch (s) {
            case "Lunes": dia = DayOfWeek.MONDAY; break;
            default: dia = null;
        }
        return dia;
    }
}
