package br.com.sifat.dao;

import br.com.sifat.model.Book;

import javax.ejb.Stateless;

@Stateless
public class BookDao extends GenericDao<Book, Long> {

    public BookDao() {
        super(Book.class);
    }
}
