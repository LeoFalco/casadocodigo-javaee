package br.com.sifat.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
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
    //@NotBlank
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(nullable = false, columnDefinition = "varchar(250)", length = 250)
    //@NotBlank
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
    //@NotBlank
    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
