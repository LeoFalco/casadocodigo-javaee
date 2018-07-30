package br.com.sifat.bean;

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
import java.util.stream.Collectors;

@Named
@ViewScoped
@Transactional
public class BookBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private BookDao bookDao;
    @Inject
    private AutorDao autorDao;

    private List<Autor> autores;
    private List<Integer> idAutoresSelecionados;
    private Book book;

    @PostConstruct
    private void init() {
        autores = autorDao.listar();
        idAutoresSelecionados = new ArrayList<>();
        book = new Book();
    }

    public void save() {
        preparaBook();
        book = bookDao.atualizar(book);
    }

    private void preparaBook() {
        List<Autor> collect = autores.stream()
                .filter(autor -> idAutoresSelecionados.contains(autor.getId()))
                .collect(Collectors.toList());

        this.book.setAutores(collect);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Integer> getIdAutoresSelecionados() {
        return idAutoresSelecionados;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setIdAutoresSelecionados(List<Integer> idAutoresSelecionados) {
        this.idAutoresSelecionados = idAutoresSelecionados;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
