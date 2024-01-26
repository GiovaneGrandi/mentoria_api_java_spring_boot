package br.com.vinicula.mentoria.model;

public class Cliente {
    private Long codigo;
    private String cpf;
    private String nome;

    public Cliente(long pkcodigocli, String cpfcli, String nomecli) {
        this.codigo = pkcodigocli;
        this.cpf = cpfcli;
        this.nome = nomecli;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long id) {
        this.codigo = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
