package br.com.vinicula.mentoria.model;

public class Carrinho {

    private Long codigo;
    private String estado;
    private Long codigocli;

    public Carrinho(Long codigo, String estado, Long codigocli) {
        this.codigo = codigo;
        this.estado = estado;
        this.codigocli = codigocli;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getCodigoCli() {
        return codigocli;
    }

    public void setCodigoCli(Long codigo) {
        this.codigocli = codigo;
    }
}
