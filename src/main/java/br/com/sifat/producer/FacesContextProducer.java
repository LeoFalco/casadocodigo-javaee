package br.com.sifat.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.context.ApplicationScoped;

import javax.faces.context.FacesContext;


@ApplicationScoped
public class FacesContextProducer {

    @Produces
    @RequestScoped
    FacesContext get() {
        return FacesContext.getCurrentInstance();
    }
}
