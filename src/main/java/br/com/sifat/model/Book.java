package br.com.sifat.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    private Long id;
    private String titulo;
    private String descricao;
    private Integer numPaginas;
    private BigDecimal preco;
    private List<Autor> autores;

    public Book() {
        this.id = 0L;
        this.titulo = "";
        this.descricao = "";
        this.numPaginas = 0;
        this.preco = BigDecimal.ZERO;
        this.autores = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "num_paginas")
    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Column(columnDefinition = "decimal(10,2)")
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @ManyToMany(targetEntity = Autor.class, fetch = FetchType.EAGER)
    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
