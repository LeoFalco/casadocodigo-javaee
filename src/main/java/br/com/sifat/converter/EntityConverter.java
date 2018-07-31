package br.com.sifat.converter;

import br.com.sifat.StringUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

@FacesConverter
public class EntityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (StringUtil.isNullOrEmpty(value)) return null;


        Collection<?> objects = uiComponent.getAttributes().values();

        return objects.stream()
                .filter((entity) -> getAsString(context, uiComponent, entity).equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Field idField = findIdField(value);
        return getIdValue(value, idField);
    }

    private Field findIdField(Object value) {
        return Arrays.stream(value.getClass().getDeclaredFields())
                .filter((field) -> field.getAnnotation(Id.class) != null)
                .findFirst()
                .orElse(null);
    }

    private String getIdValue(Object value, Field idField) {
        try {
            Field field = value.getClass().getDeclaredField(idField.getName());
            field.setAccessible(true);
            return field.get(value).toString();
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
