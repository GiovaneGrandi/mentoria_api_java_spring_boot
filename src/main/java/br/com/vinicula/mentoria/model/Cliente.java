package br.com.vinicula.mentoria.model;

public class Cliente {
    private long codigo;
    private String cpf;
    private String nome;

    public Cliente(long pkcodigocli, String cpfcli, String nomecli) {
        this.codigo = pkcodigocli;
        this.cpf = cpfcli;
        this.nome = nomecli;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
