package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Cliente;
import br.com.vinicula.mentoria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{cpf}")
    public Cliente obterClientePorCpf(@PathVariable String cpf) {
        return clienteRepository.localizaPorCpf(cpf);
    }

    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.salva(cliente);
    }

    @PutMapping("/{cpf}")
    public Cliente atualizarCliente(@PathVariable String cpf, @RequestBody Cliente clienteAtualizado) {
        return clienteAtualizado;
    }

    @DeleteMapping("/{cpf}")
    public void deletarCliente(@PathVariable String cpf) {
    }

}
