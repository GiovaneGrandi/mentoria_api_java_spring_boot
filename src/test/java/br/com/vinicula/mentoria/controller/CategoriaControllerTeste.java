package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Categoria;
import br.com.vinicula.mentoria.repository.CategoriaRepository;
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
@WebMvcTest(CategoriaController.class)
@AutoConfigureMockMvc
public class CategoriaControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoriaRepository categoriaRepository;

    @Test
    public void testRetornaTodasCategorias() throws Exception {
        when(categoriaRepository.pegaTodasCategorias()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/categorias"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRetornaCategoriaPeloCodigo() throws Exception {
        Categoria categoria = new Categoria(1L, "Categoria Teste");

        when(categoriaRepository.pegaCategoriaPorCodigo(1L)).thenReturn(categoria);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/categorias/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSalvaCategoria() throws Exception {
        Categoria categoria = new Categoria(1L, "Categoria Teste");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/categorias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"nome\": \"Categoria Teste\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAlteraCategoria() throws Exception {
        Categoria categoria = new Categoria(1L, "Categoria Teste");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/categorias/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"nome\": \"Categoria Teste\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeletaCategoria() throws Exception {
        doNothing().when(categoriaRepository).excluiCategoria(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/categorias/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
