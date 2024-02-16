package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Carrinho;
import br.com.vinicula.mentoria.repository.CarrinhoRepository;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarrinhoController.class)
@AutoConfigureMockMvc
public class CarrinhoControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarrinhoRepository carrinhoRepository;

    @Test
    public void testRetornaTodosCarrinhos() throws Exception {
        when(carrinhoRepository.pegaTodosCarrinhos()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carrinhos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRetornaCarrinhoPeloCodigo() throws Exception {
        Carrinho carrinho = new Carrinho(1L, "aberto", 1L);

        when(carrinhoRepository.pegaCarrinhoPorCodigo(1L)).thenReturn(carrinho);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/carrinhos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSalvaCarrinho() throws Exception {
        Carrinho carrinho = new Carrinho(1L, "aberto", 1L);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/carrinhos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"estado\": \"aberto\", \"codigocli\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAtualizaCarrinho() throws Exception {
        Carrinho carrinho = new Carrinho(1L, "aberto", 1L);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/carrinhos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"estado\": \"aberto\", \"codigocli\": 1}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeletaCarrinho() throws Exception {
        doNothing().when(carrinhoRepository).excluiCarrinho(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/carrinhos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
