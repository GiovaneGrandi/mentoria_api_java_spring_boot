package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.mapper.ClienteRowMapper;
import br.com.vinicula.mentoria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ClienteRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Cliente localizaPorCpf(String cpf) {
        String sql = "SELECT * FROM tbcliente WHERE cpfcli = :cpf";

        Map<String, Object> params = new HashMap<>();
        params.put("cpf", cpf);

        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                    new Cliente(
                            rs.getLong("pkcodigocli"),
                            rs.getString("cpfcli"),
                            rs.getString("nomecli")
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Cliente salva(Cliente cliente) {
        String sql = "INSERT INTO tbcliente (pkcodigocli, cpfcli, nomecli) " +
                "VALUES (:codigo, :cpf, :nome)";

        Map<String, Object> params = new HashMap<>();
        params.put("id", cliente.getCodigo());
        params.put("cpf", cliente.getCpf());
        params.put("nome", cliente.getNome());

        namedParameterJdbcTemplate.update(sql, params);

        return cliente;
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM tbcliente";

        return namedParameterJdbcTemplate.query(sql, new ClienteRowMapper());
    }

}
