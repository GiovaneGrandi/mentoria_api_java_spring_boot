package br.com.vinicula.mentoria.config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateConfigTeste {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "SELECT 1";
        Integer result = namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Integer.class);

        assertEquals(Integer.valueOf(1), result);
    }

}
