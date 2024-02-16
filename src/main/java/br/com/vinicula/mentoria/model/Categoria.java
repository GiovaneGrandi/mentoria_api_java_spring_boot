package br.com.vinicula.mentoria.model;

public class Categoria {

    private long codigo;

    private String nome;

    public Categoria(long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

}
