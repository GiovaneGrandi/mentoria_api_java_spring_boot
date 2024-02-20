package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.mapper.ClienteRowMapper;
import br.com.vinicula.mentoria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Cliente> pegaTodosClientes() {
        String sql = "SELECT * FROM tbcliente";
        return jdbcTemplate.query(sql, new ClienteRowMapper());
    }

    public Cliente pegaClientePorCpf(String cpf) {
        String sql = "SELECT * FROM tbcliente WHERE cpfcli = :cpf";
        Map<String, Object> params = new HashMap<>();
        params.put("cpf", cpf);
        return jdbcTemplate.queryForObject(sql, params, new ClienteRowMapper());
    }

    public void criaCliente(Cliente cliente) {
        String sql = "INSERT INTO tbcliente (cpfcli, nomecli) VALUES (:cpf, :nome)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", cliente.getCpf());
        params.addValue("nome", cliente.getNome());
        jdbcTemplate.update(sql, params);
    }

    public void atualizaCliente(Long codigo, Cliente cliente) {
        StringBuilder sqlBuilder = new StringBuilder("UPDATE tbcliente SET ");
        MapSqlParameterSource params = new MapSqlParameterSource();

        if (cliente.getCpf() != null) {
            sqlBuilder.append("cpfcli = :cpf, ");
            params.addValue("cpf", cliente.getCpf());
        }

        if (cliente.getNome() != null) {
            sqlBuilder.append("nomecli = :nome, ");
            params.addValue("nome", cliente.getNome());
        }

        sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());
        sqlBuilder.append(" WHERE pkcodigocli = :codigo");

        params.addValue("codigo", codigo);

        jdbcTemplate.update(sqlBuilder.toString(), params);
    }

    public void excluiCliente(Long codigo) {
        String sql = "DELETE FROM tbcliente WHERE pkcodigocli = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        jdbcTemplate.update(sql, params);
    }

}
