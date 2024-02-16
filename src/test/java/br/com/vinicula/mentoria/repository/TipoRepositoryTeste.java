package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.mapper.TipoRowMapper;
import br.com.vinicula.mentoria.model.Tipo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class TipoRepositoryTeste {

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    private TipoRepository tipoRepository;

    @BeforeEach
    void setUp() {
        tipoRepository = new TipoRepository();
    }

    @Test
    void testPegaTodosTipos_DeveRetornarListaVazia_QuandoNenhumTipoExiste() {
        when(jdbcTemplate.query(anyString(), any(TipoRowMapper.class))).thenReturn(Collections.emptyList());

        List<Tipo> tipos = tipoRepository.pegaTodosTipos();

        assertTrue(tipos.isEmpty());
    }

    @Test
    void testPegaTipoPorCodigo_DeveRetornarTipo_QuandoCodigoExistir() {
        Tipo tipo = new Tipo(1L, "Teste");
        when(jdbcTemplate.queryForObject(anyString(), anyMap(), any(TipoRowMapper.class))).thenReturn(tipo);

        Tipo tipoRetornado = tipoRepository.pegaTipoPorCodigo(1L);

        assertEquals(tipo, tipoRetornado);
    }

    @Test
    void testCriaTipo_DeveCriarNovoTipo_QuandoParametrosValidos() {
        Tipo tipo = new Tipo(1L, "Novo Tipo");
        doNothing().when(jdbcTemplate).update(anyString(), any(MapSqlParameterSource.class));

        assertDoesNotThrow(() -> tipoRepository.criaTipo(tipo));
    }

    @Test
    void testCriaTipo_DeveLancarDataAccessException_QuandoFalhaNaInsercao() {
        Tipo tipo = new Tipo(1L, "Novo Tipo");
        doThrow(DataAccessException.class).when(jdbcTemplate).update(anyString(), any(MapSqlParameterSource.class));

        assertThrows(DataAccessException.class, () -> tipoRepository.criaTipo(tipo));
    }

    @Test
    void testAtualizaTipo_DeveAtualizarTipo_QuandoCodigoExistir() {
        Tipo tipo = new Tipo(1L, "Tipo Atualizado");
        doNothing().when(jdbcTemplate).update(anyString(), any(MapSqlParameterSource.class));

        assertDoesNotThrow(() -> tipoRepository.atualizaTipo(1L, tipo));
    }

    @Test
    void testAtualizaTipo_DeveLancarDataAccessException_QuandoFalhaNaAtualizacao() {
        Tipo tipo = new Tipo(1L, "Tipo Atualizado");
        doThrow(DataAccessException.class).when(jdbcTemplate).update(anyString(), any(MapSqlParameterSource.class));

        assertThrows(DataAccessException.class, () -> tipoRepository.atualizaTipo(1L, tipo));
    }

    @Test
    void testExcluiTipo_DeveExcluirTipo_QuandoCodigoExistir() {
        doNothing().when(jdbcTemplate).update(anyString(), any(Map.class));

        assertDoesNotThrow(() -> tipoRepository.excluiTipo(1L));
    }

    @Test
    void testExcluiTipo_DeveLancarDataAccessException_QuandoFalhaNaExclusao() {
        doThrow(DataAccessException.class).when(jdbcTemplate).update(anyString(), any(Map.class));

        assertThrows(DataAccessException.class, () -> tipoRepository.excluiTipo(1L));
    }

}
