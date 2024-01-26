package br.com.vinicula.mentoria.mapper;

import br.com.vinicula.mentoria.model.Carrinho;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarrinhoRowMapper implements RowMapper<Carrinho>{

    @Override
    public Carrinho mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Carrinho(
                rs.getLong("pkcodigocar"),
                rs.getString("estadocar"),
                rs.getLong("fkcodigocli")
        );
    }

}
