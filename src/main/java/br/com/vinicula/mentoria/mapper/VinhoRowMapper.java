package br.com.vinicula.mentoria.mapper;

import br.com.vinicula.mentoria.model.Vinho;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VinhoRowMapper implements RowMapper<Vinho>{

    @Override
    public Vinho mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Vinho(
                rs.getLong("pkcodigovin"),
                rs.getString("nomevin"),
                rs.getFloat("precovin"),
                rs.getInt("anovin"),
                rs.getString("paisvin"),
                rs.getInt("estoquevin"),
                rs.getLong("fkcodigocat"),
                rs.getLong("fkcodigotip")
        );
    }

}
