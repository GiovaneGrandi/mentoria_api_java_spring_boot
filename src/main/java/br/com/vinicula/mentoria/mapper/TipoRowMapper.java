package br.com.vinicula.mentoria.mapper;

import br.com.vinicula.mentoria.model.Tipo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoRowMapper implements RowMapper<Tipo>{

    @Override
    public Tipo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Tipo(
                rs.getLong("pkcodigotip"),
                rs.getString("nometip")
        );
    }

}
