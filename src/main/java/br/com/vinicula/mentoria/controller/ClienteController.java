package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Cliente;
import br.com.vinicula.mentoria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> retornaTodosClientes() {
        return clienteRepository.pegaTodosClientes();
    }

    @GetMapping("/{cpf}")
    public Cliente retornaClientePeloCodigo(@PathVariable String cpf) {
        return clienteRepository.pegaClientePorCpf(cpf);
    }

    @PostMapping
    public void salvaCliente(@RequestBody Cliente cliente) {
        clienteRepository.criaCliente(cliente);
    }

    @PutMapping("/{codigo}")
    public void atualizaCliente(@PathVariable Long codigo, @RequestBody Cliente cliente) {
        clienteRepository.atualizaCliente(codigo, cliente);
    }

    @DeleteMapping("/{codigo}")
    public void deletaCliente(@PathVariable Long codigo) {
        clienteRepository.excluiCliente(codigo);
    }

}
