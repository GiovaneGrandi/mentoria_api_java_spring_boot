package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Carrinho;
import br.com.vinicula.mentoria.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @GetMapping
    public List<Carrinho> retornaTodosCarrinhos() {
        return carrinhoRepository.pegaTodosCarrinhos();
    }

    @GetMapping("/{codigo}")
    public Carrinho retornaCarrinhoPeloCodigo(@PathVariable Long codigo) {
        return carrinhoRepository.pegaCarrinhoPorCodigo(codigo);
    }

    @PostMapping
    public void salvaCarrinho(@RequestBody Carrinho carrinho) {
        carrinhoRepository.criaCarrinho(carrinho);
    }

    @PutMapping("/{codigo}")
    public void atualizaCarrinho(@PathVariable Long codigo, @RequestBody Carrinho carrinho) {
        carrinhoRepository.atualizaCarrinho(codigo, carrinho);
    }

    @DeleteMapping("/{codigo}")
    public void deletaCarrinho(@PathVariable Long codigo) {
        carrinhoRepository.excluiCarrinho(codigo);
    }

}
