package br.com.sifat.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    private Long id;
    private String titulo;
    private String descricao;
    private Integer numPaginas;
    private BigDecimal preco;
    private Calendar dataLancamento;
    private List<Autor> autores;

    public Book() {
        this.id = 0L;
        this.titulo = "";
        this.descricao = "";
        this.numPaginas = 0;
        this.preco = BigDecimal.ZERO;
        this.autores = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.APRIL, 8);
        this.dataLancamento = calendar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, columnDefinition = "varchar(100)", length = 100)
    @NotNull
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(nullable = false, columnDefinition = "varchar(250)", length = 250)
    @NotNull
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "num_paginas", nullable = false)
    @NotNull
    @Min(1)
    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    @NotNull
    @DecimalMin("0")
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Column(name = "data_lancamento", nullable = false, columnDefinition = "date")
    @Future
    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public Book setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    @ManyToMany(targetEntity = Autor.class, fetch = FetchType.EAGER)
    @Column(nullable = false)
    @JoinTable(name = "book_autor",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id")
    )

    @NotNull
    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(titulo, book.titulo) &&
                Objects.equals(descricao, book.descricao) &&
                Objects.equals(numPaginas, book.numPaginas) &&
                Objects.equals(preco, book.preco) &&
                Objects.equals(dataLancamento, book.dataLancamento) &&
                Objects.equals(autores, book.autores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descricao, numPaginas, preco, dataLancamento, autores);
    }
}
