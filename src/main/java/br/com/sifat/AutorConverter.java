package br.com.sifat;

import br.com.sifat.model.Autor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Autor.class)
public class AutorConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null) {
            return uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
        if (obj != null) {
            Autor autor = (Autor) obj;
            if (autor.getId() != null) {
                uiComponent.getAttributes().put(autor.getId().toString(), autor);
                if (autor.getNome() != null && !autor.getNome().equals("")) {
                    return autor.getNome();
                }
            }
        }
        return "";
    }
}
