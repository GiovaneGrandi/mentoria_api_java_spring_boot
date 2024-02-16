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
        String sql = "UPDATE tbvinho SET nomevin = :nome, precovin = :preco, anovin = :ano, paisvin = :pais, " +
                "estoquevin = :estoque, fkcodigocat = :codigoCategoria, fkcodigotip = :codigoTipo " +
                "WHERE pkcodigovin = :codigo";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codigo", codigo);
        params.addValue("nome", vinho.getNome());
        params.addValue("preco", vinho.getPreco());
        params.addValue("ano", vinho.getAno());
        params.addValue("pais", vinho.getPais());
        params.addValue("estoque", vinho.getEstoque());
        params.addValue("codigoCategoria", vinho.getCodigoCategoria());
        params.addValue("codigoTipo", vinho.getCodigoTipo());
        jdbcTemplate.update(sql, params);
    }

    public void excluiVinho(Long codigo) {
        String sql = "DELETE FROM tbvinho WHERE pkcodigovin = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        jdbcTemplate.update(sql, params);
    }

}