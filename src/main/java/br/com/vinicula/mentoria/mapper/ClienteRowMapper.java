package br.com.vinicula.mentoria.mapper;

import br.com.vinicula.mentoria.model.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRowMapper implements RowMapper<Cliente> {

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Cliente(
                rs.getLong("pkcodigocli"),
                rs.getString("cpfcli"),
                rs.getString("nomecli")
        );
    }

}
