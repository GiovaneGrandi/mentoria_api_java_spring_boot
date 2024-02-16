package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Tipo;
import br.com.vinicula.mentoria.repository.TipoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TipoController.class)
@AutoConfigureMockMvc
public class TipoControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TipoRepository tipoRepository;

    @Test
    public void testRetornaTodosTipos() throws Exception {
        when(tipoRepository.pegaTodosTipos()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tipos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRetornaTipoPeloCodigo() throws Exception {
        Tipo tipo = new Tipo(1L, "Tipo Teste");

        when(tipoRepository.pegaTipoPorCodigo(1L)).thenReturn(tipo);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tipos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSalvaTipo() throws Exception {
        Tipo tipo = new Tipo(1L, "Tipo Teste");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tipos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"nome\": \"Tipo Teste\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAlteraTipo() throws Exception {
        Tipo tipo = new Tipo(1L, "Tipo Teste");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/tipos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"nome\": \"Tipo Teste\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeletaTipo() throws Exception {
        doNothing().when(tipoRepository).excluiTipo(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/tipos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
