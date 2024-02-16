package br.com.vinicula.mentoria.model;

public class Vinho {

    private long codigo;
    private String nome;
    private float preco;
    private int ano;
    private String pais;
    private int estoque;
    private long codigoCategoria;
    private long codigoTipo;

    public Vinho(long codigo, String nome, float preco, int ano, String pais, int estoque, long codigoCategoria, long codigoTipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.ano = ano;
        this.pais = pais;
        this.estoque = estoque;
        this.codigoCategoria = codigoCategoria;
        this.codigoTipo = codigoTipo;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getAno() {
        return ano;
    }

    public String getPais() {
        return pais;
    }

    public int getEstoque() {
        return estoque;
    }

    public long getCodigoCategoria() {
        return codigoCategoria;
    }

    public long getCodigoTipo() {
        return codigoTipo;
    }
}
