package br.com.sifat.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.Calendar;
import java.util.Date;

@FacesConverter
public class CalendarHtml5Converter implements Converter {

    private static DateTimeConverter dateTimeConverter = new DateTimeConverter();

    static {
        dateTimeConverter.setPattern("dd-MM-yyy");
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
