package br.com.vinicula.mentoria.model;

public class Tipo {

    private long codigo;

    private String nome;

    public Tipo(long codigo, String nome) {
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
