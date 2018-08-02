package br.com.sifat.dao;

import br.com.sifat.model.Arquivo;

import javax.ejb.Stateless;

@Stateless
public class ArquivoDao extends GenericDao<Arquivo, Integer> {

    public ArquivoDao() {
        super(Arquivo.class);
    }

    public void salvar(Arquivo arquivo) {
        super.atualizar(arquivo);
    }

}
