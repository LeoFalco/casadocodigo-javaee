package br.com.sifat.mb;

import br.com.sifat.GsonUtil;
import br.com.sifat.dao.AutorDao;
import br.com.sifat.dao.BookDao;
import br.com.sifat.model.Autor;
import br.com.sifat.model.Book;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@Transactional
public class BookBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private BookDao bookDao;
    @Inject
    private AutorDao autorDao;

    private Book book = new Book();
    private List<Autor> autoresSelecionados = new ArrayList<>();
    private List<Autor> autores;


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @PostConstruct
    private void init() {
        autores = autorDao.listar();
        this.book = bookDao.find(1L);
    }


    public void save() {
        System.out.println("Chegou aqui: " + book.getTitulo());
        //this.book.setAutores(this.getAutoresSelecionados());
        System.out.println(GsonUtil.toJson(book));
        //this.book = this.bookDao.atualizar(book);

    }

    public List<Autor> getAutoresSelecionados() {
        return autoresSelecionados;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutoresSelecionados(List<Autor> autoresSelecionados) {
        this.autoresSelecionados = autoresSelecionados;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }


}
