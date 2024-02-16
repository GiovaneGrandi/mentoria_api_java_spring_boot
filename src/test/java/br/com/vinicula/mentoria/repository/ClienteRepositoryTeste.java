package br.com.vinicula.mentoria.repository;

import br.com.vinicula.mentoria.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteRepositoryTeste {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testFindByCpf() {
        String cpf = "123456789";
        Cliente cliente = new Cliente(5L, cpf, "Nome do Cliente");

        clienteRepository.criaCliente(cliente);

        Cliente resultado = clienteRepository.pegaClientePorCpf(cpf);

        assertNotNull(resultado);
        assertEquals(cliente.getCodigo(), resultado.getCodigo());
        assertEquals(cliente.getCpf(), resultado.getCpf());
        assertEquals(cliente.getNome(), resultado.getNome());
    }

    @Test
    public void testFindByCpfNotFound() {
        String cpfNaoExistente = "987654321";
        Cliente resultado = clienteRepository.pegaClientePorCpf(cpfNaoExistente);

        assertNull(resultado);
    }

}
