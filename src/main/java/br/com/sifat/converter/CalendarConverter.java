package br.com.sifat.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@FacesConverter(forClass = Calendar.class)
public class CalendarConverter implements Converter {

    private static DateTimeConverter dateTimeConverter = new DateTimeConverter();
    private static Logger logger = Logger.getLogger(CalendarConverter.class.getName());

    static {
        dateTimeConverter.setPattern("dd-MM-yyy");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Date date = (Date) dateTimeConverter.getAsObject(context, component, value);

        if (date == null) return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        logger.log(Level.INFO, "Recuperando objeto " + calendar);
        return calendar;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null) return null;

        Calendar calendar = (Calendar) value;

        String asString = dateTimeConverter.getAsString(context, component, calendar.getTime());
        logger.log(Level.INFO, "Serializando objeto " + asString);
        return asString;
    }
}
