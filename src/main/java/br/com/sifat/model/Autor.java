package br.com.sifat.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Autor {

    private Integer id;
    private String nome;
    private List<Book> books;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autores", targetEntity = Book.class)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) &&
                Objects.equals(nome, autor.nome) &&
                Objects.equals(books, autor.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, books);
    }
}