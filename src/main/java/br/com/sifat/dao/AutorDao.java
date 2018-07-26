package br.com.sifat.dao;

import br.com.sifat.model.Autor;

import javax.ejb.Stateless;

@Stateless
public class AutorDao extends GenericDao<Autor, Integer> {
    public AutorDao() {
        super(Autor.class);
    }
}
