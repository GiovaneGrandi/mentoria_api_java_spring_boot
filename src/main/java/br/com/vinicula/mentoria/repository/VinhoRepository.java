package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.mapper.VinhoRowMapper;
import br.com.vinicula.mentoria.model.Vinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VinhoRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Vinho> pegaTodosVinhos() {
        String sql = "SELECT * FROM tbvinho";
        return jdbcTemplate.query(sql, new VinhoRowMapper());
    }

    public Vinho pegaVinhoPorCodigo(Long codigo) {
        String sql = "SELECT * FROM tbvinho WHERE pkcodigovin = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        return jdbcTemplate.queryForObject(sql, params, new VinhoRowMapper());
    }

    public void criaVinho(Vinho vinho) {
        String sql = "INSERT INTO tbvinho (pkcodigocli, nomevin, precovin, anovin, paisvin, estoquevin, fkcodigocat, fkcodigotip)" +
                "VALUES (:codigo, :nome, :preco, :ano, :pais, :estoque, :codigoCategoria, :codigoTipo)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codigo", vinho.getCodigo());
        params.addValue("nome", vinho.getNome());
        params.addValue("preco", vinho.getPreco());
        params.addValue("ano", vinho.getAno());
        params.addValue("pais", vinho.getPais());
        params.addValue("estoque", vinho.getEstoque());
        params.addValue("codigoCategoria", vinho.getCodigoCategoria());
        params.addValue("codigoTipo", vinho.getCodigoTipo());

        jdbcTemplate.update(sql, params);
    }

    public void atualizaVinho(Long codigo, Vinho vinho) {
        StringBuilder sqlBuilder = new StringBuilder("UPDATE tbvinho SET ");
        MapSqlParameterSource params = new MapSqlParameterSource();

        if (vinho.getNome() != null) {
            sqlBuilder.append("nomevin = :nome, ");
            params.addValue("nome", vinho.getNome());
        }

        if (vinho.getPreco() != null) {
            sqlBuilder.append("precovin = :preco, ");
            params.addValue("preco", vinho.getPreco());
        }

        if (vinho.getAno() != null) {
            sqlBuilder.append("anovin = :ano, ");
            params.addValue("ano", vinho.getAno());
        }

        if (vinho.getPais() != null) {
            sqlBuilder.append("paisvin = :pais, ");
            params.addValue("pais", vinho.getPais());
        }

        if (vinho.getEstoque() != null) {
            sqlBuilder.append("estoquevin = :estoque, ");
            params.addValue("estoque", vinho.getEstoque());
        }

        if (vinho.getCodigoCategoria() != null) {
            sqlBuilder.append("fkcodigocat = :codigoCategoria, ");
            params.addValue("codigoCategoria", vinho.getCodigoCategoria());
        }

        if (vinho.getCodigoTipo() != null) {
            sqlBuilder.append("fkcodigotip = :codigoTipo, ");
            params.addValue("codigoTipo", vinho.getCodigoTipo());
        }

        sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());
        sqlBuilder.append(" WHERE pkcodigovin = :codigo");

        params.addValue("codigo", codigo);

        jdbcTemplate.update(sqlBuilder.toString(), params);
    }

    public void excluiVinho(Long codigo) {
        String sql = "DELETE FROM tbvinho WHERE pkcodigovin = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        jdbcTemplate.update(sql, params);
    }

}