package br.com.vinicula.mentoria.mapper;

import br.com.vinicula.mentoria.model.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaRowMapper implements RowMapper<Categoria>{

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Categoria(
                rs.getLong("pkcodigocat"),
                rs.getString("nomecat")
        );
    }

}
