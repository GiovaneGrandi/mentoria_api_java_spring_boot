package br.com.vinicula.mentoria.model;

public class Carrinho {

    private long codigo;
    private String estado;
    private long codigocli;

    public Carrinho(long codigo, String estado, long codigocli) {
        this.codigo = codigo;
        this.estado = estado;
        this.codigocli = codigocli;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public long getCodigoCli() {
        return codigocli;
    }

}
