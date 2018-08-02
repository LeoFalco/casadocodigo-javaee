package br.com.sifat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "arquivo")
public class Arquivo {

    private Integer id;
    private String descricao;
    private byte[] arquivo;
    private String contentType;
    private String nome;
    private long tamanho;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 250, nullable = false)
    @NotNull
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Lob
    @Column(nullable = false)
    @NotNull
    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    @Column(length = 50, name = "content_type")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Column(length = 100)
    @NotNull
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }
}
