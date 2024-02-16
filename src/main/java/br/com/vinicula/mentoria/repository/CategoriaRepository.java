package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.mapper.CategoriaRowMapper;
  import br.com.vinicula.mentoria.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoriaRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Categoria> pegaTodasCategorias() {
        String sql = "SELECT * FROM tbcategoria";
        return jdbcTemplate.query(sql, new CategoriaRowMapper());
    }

    public Categoria pegaCategoriaPorCodigo(Long codigo) {
        String sql = "SELECT * FROM tbcategoria WHERE pkcodigocat = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        return jdbcTemplate.queryForObject(sql, params, new CategoriaRowMapper());
    }

    public void criaCategoria(Categoria categoria) {
        String sql = "INSERT INTO tbcategoria (nometip) VALUES (:nome)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nome", categoria.getNome());
        jdbcTemplate.update(sql, params);
    }

    public void atualizaCategoria(Long codigo, Categoria categoria) {
        String sql = "UPDATE tbcategoria SET nomecat = :nome WHERE pkcodigocat = :codigo";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codigo", codigo);
        params.addValue("nome", categoria.getNome());
        jdbcTemplate.update(sql, params);
    }

    public void excluiCategoria(Long codigo) {
        String sql = "DELETE FROM tbcategoria WHERE pkcodigocat = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        jdbcTemplate.update(sql, params);
    }

}
