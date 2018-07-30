package br.com.sifat.dao;

import br.com.sifat.model.Book;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class BookDao extends GenericDao<Book, Long> {

    public BookDao() {
        super(Book.class);
    }

    @Override
    public List<Book> listar() {
        TypedQuery<Book> query = em.createQuery("select distinct b from Book b join fetch b.autores", Book.class);
        return query.getResultList();
    }
}
