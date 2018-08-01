package br.com.sifat.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

@Named
// classe de converter para calendar aproveitando as funcionalidades do DateTimeConverter
public class CalendarConverter implements Converter {

    private static DateTimeConverter dateTimeConverter = new DateTimeConverter();
    private static Logger logger = Logger.getLogger(CalendarConverter.class.getName());

    static {
        dateTimeConverter.setPattern("dd-MM-yyyy");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Date date = (Date) dateTimeConverter.getAsObject(context, component, value);

        if (date == null) return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null) return null;

        Calendar calendar = (Calendar) value;

        return dateTimeConverter.getAsString(context, component, calendar.getTime());
    }
}
