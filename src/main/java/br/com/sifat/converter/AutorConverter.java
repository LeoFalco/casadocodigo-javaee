package br.com.sifat.converter;

import br.com.sifat.GsonUtil;
import br.com.sifat.StringUtil;
import br.com.sifat.dao.AutorDao;
import br.com.sifat.model.Autor;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@FacesConverter(forClass = Autor.class)
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
            logger.log(Level.INFO, e.getMessage());
            return null;
        }

        System.out.println(s);
        System.out.println(autorDao);
        Autor autor = autorDao.find(id);
        GsonUtil.toJson(autor);
        return autor;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Autor autor = (Autor) o;
        return autor.getId().toString();
    }
}
