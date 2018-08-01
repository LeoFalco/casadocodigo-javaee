package br.com.sifat.converter;

import br.com.sifat.StringUtil;
import br.com.sifat.dao.AutorDao;
import br.com.sifat.model.Autor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
public class AutorConverter implements Converter {

    Logger logger = Logger.getLogger(AutorConverter.class.getName());

    @Inject
    AutorDao autorDao;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (StringUtil.isNullOrEmpty(s)) return null;

        int id;
        try {
            id = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, e.getMessage());
            return null;
        }

        // pode retornar nulo
        return autorDao.find(id);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Autor autor = (Autor) o;
        return autor.getId().toString();
    }
}
