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
    public List<Carrinho> getAllCarrinhos() {
        return carrinhoRepository.getAllCarrinhos();
    }

    @GetMapping("/{codigo}")
    public Carrinho getCarrinhoById(@PathVariable Long codigo) {
        return carrinhoRepository.getCarrinhoById(codigo);
    }

    @PostMapping
    public void createCarrinho(@RequestBody Carrinho carrinho) {
        carrinhoRepository.createCarrinho(carrinho);
    }

    @PutMapping("/{codigo}")
    public void updateCarrinho(@PathVariable Long codigo, @RequestBody Carrinho carrinho) {
        carrinhoRepository.updateCarrinho(codigo, carrinho);
    }

    @DeleteMapping("/{codigo}")
    public void deleteCarrinho(@PathVariable Long codigo) {
        carrinhoRepository.deleteCarrinho(codigo);
    }

}
