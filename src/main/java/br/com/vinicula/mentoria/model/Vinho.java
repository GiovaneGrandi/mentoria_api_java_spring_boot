package br.com.vinicula.mentoria.model;

public class Vinho {

    private long codigo;
    private String nome;
    private Float preco;
    private Integer ano;
    private String pais;
    private Integer estoque;
    private Long codigoCategoria;
    private Long codigoTipo;

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

    public Float getPreco() {
        return preco;
    }

    public Integer getAno() {
        return ano;
    }

    public String getPais() {
        return pais;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Long getCodigoCategoria() {
        return codigoCategoria;
    }

    public Long getCodigoTipo() {
        return codigoTipo;
    }
}
