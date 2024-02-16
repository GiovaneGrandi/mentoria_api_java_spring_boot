package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Cliente;
import br.com.vinicula.mentoria.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc
public class ClienteControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testRetornaTodosClientes() throws Exception {
        when(clienteRepository.pegaTodosClientes()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clientes"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRetornaClientePeloCpf() throws Exception {
        Cliente cliente = new Cliente(1L, "12345678900", "Cliente Teste");

        when(clienteRepository.pegaClientePorCpf(anyString())).thenReturn(cliente);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/clientes/12345678900"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSalvaCliente() throws Exception {
        Cliente cliente = new Cliente(1L, "12345678900", "Cliente Teste");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"cpf\": \"12345678900\", \"nome\": \"Cliente Teste\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAtualizaCliente() throws Exception {
        Cliente cliente = new Cliente(1L, "12345678900", "Cliente Teste");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"codigo\": 1, \"cpf\": \"12345678900\", \"nome\": \"Cliente Teste\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeletaCliente() throws Exception {
        doNothing().when(clienteRepository).excluiCliente(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/clientes/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
