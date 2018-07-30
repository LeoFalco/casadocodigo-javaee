package br.com.sifat.service;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Stateless
public class MessageService {

    @Inject
    FacesContext facesContext;

    public void addFlash(FacesMessage message) {
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, message);
    }
}
