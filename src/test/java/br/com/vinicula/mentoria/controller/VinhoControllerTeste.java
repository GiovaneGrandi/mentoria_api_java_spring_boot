package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Vinho;
import br.com.vinicula.mentoria.repository.VinhoRepository;
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
@WebMvcTest(VinhoController.class)
@AutoConfigureMockMvc
public class VinhoControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VinhoRepository vinhoRepository;

    @Test
    public void testRetornaTodosVinhos() throws Exception {
        when(vinhoRepository.pegaTodosVinhos()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vinhos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRetornaVinhoPeloCodigo() throws Exception {
        Vinho vinho = new Vinho(1L, "Vinho Teste", 50.0f, 2022, "Brasil", 10, 1L, 1L);

        when(vinhoRepository.pegaVinhoPorCodigo(1L)).thenReturn(vinho);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vinhos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSalvaVinho() throws Exception {
        Vinho vinho = new Vinho(1L, "Vinho Teste", 50.0f, 2022, "Brasil", 10, 1L, 1L);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/vinhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"nome\": \"Vinho Teste\", \"preco\": 50.0, \"ano\": 2022, \"pais\": \"Brasil\", \"estoque\": 10, \"codigoCategoria\": 1, \"codigoTipo\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAlteraVinho() throws Exception {
        Vinho vinho = new Vinho(1L, "Vinho Teste", 50.0f, 2022, "Brasil", 10, 1L, 1L);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/vinhos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"nome\": \"Vinho Teste\", \"preco\": 50.0, \"ano\": 2022, \"pais\": \"Brasil\", \"estoque\": 10, \"codigoCategoria\": 1, \"codigoTipo\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeletaVinho() throws Exception {
        doNothing().when(vinhoRepository).excluiVinho(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/vinhos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
