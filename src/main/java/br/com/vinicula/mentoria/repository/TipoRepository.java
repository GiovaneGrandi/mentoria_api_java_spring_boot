package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.mapper.TipoRowMapper;
import br.com.vinicula.mentoria.model.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TipoRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Tipo> pegaTodosTipos() {
        String sql = "SELECT * FROM tbtipo";
        return jdbcTemplate.query(sql, new TipoRowMapper());
    }

    public Tipo pegaTipoPorCodigo(Long codigo) {
        String sql = "SELECT * FROM tbtipo WHERE pkcodigotip = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        return jdbcTemplate.queryForObject(sql, params, new TipoRowMapper());
    }

    public void criaTipo(Tipo tipo) {
        String sql = "INSERT INTO tbtipo (nometip) VALUES (:nome)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("nome", tipo.getNome());
        jdbcTemplate.update(sql, params);
    }

    public void atualizaTipo(Long codigo, Tipo tipo) {
        String sql = "UPDATE tbtipo SET nometip = :nome WHERE pkcodigotip = :codigo";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codigo", codigo);
        params.addValue("nome", tipo.getNome());
        jdbcTemplate.update(sql, params);
    }

    public void excluiTipo(Long codigo) {
        String sql = "DELETE FROM tbtipo WHERE pkcodigotip = :codigo";
        Map<String, Object> params = new HashMap<>();
        params.put("codigo", codigo);
        jdbcTemplate.update(sql, params);
    }

}
