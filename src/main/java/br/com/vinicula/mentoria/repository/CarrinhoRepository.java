package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.mapper.CarrinhoRowMapper;
import br.com.vinicula.mentoria.model.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarrinhoRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Carrinho> pegaTodosCarrinhos() {
        String sql = "SELECT * FROM tbcarrinho";
        return jdbcTemplate.query(sql, new CarrinhoRowMapper());
    }

    public Carrinho pegaCarrinhoPorCodigo(Long codigo) {
        String sql = "SELECT * FROM tbcarrinho WHERE pkcodigocar = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        return jdbcTemplate.queryForObject(sql, params, new CarrinhoRowMapper());
    }

    public void criaCarrinho(Carrinho carrinho) {
        String sql = "INSERT INTO tbcarrinho (estadocar, fkcodigocli) VALUES (:estado, :codigocli)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("estado", carrinho.getEstado());
        params.addValue("codigocli", carrinho.getCodigoCli());
        jdbcTemplate.update(sql, params);
    }

    public void atualizaCarrinho(Long codigo, Carrinho carrinho) {
        StringBuilder sqlBuilder = new StringBuilder("UPDATE tbcarrinho SET ");
        MapSqlParameterSource params = new MapSqlParameterSource();

        if (carrinho.getEstado() != null) {
            sqlBuilder.append("estadocar = :estado, ");
            params.addValue("estado", carrinho.getEstado());
        }

        if (carrinho.getCodigoCli() != null) {
            sqlBuilder.append("fkcodigocli = :codigocli, ");
            params.addValue("codigocli", carrinho.getCodigoCli());
        }

        sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());
        sqlBuilder.append(" WHERE pkcodigocar = :codigo");

        params.addValue("codigo", codigo);

        jdbcTemplate.update(sqlBuilder.toString(), params);
    }

    public void excluiCarrinho(Long codigo) {
        String sql = "DELETE FROM tbcarrinho WHERE pkcodigocar = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        jdbcTemplate.update(sql, params);
    }

}
