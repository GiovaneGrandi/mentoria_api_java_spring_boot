package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Vinho;
import br.com.vinicula.mentoria.repository.VinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vinhos")
public class VinhoController {

    @Autowired
    private VinhoRepository vinhoRepository;

    @GetMapping
    public List<Vinho> retornaTodosVinhos() {
        return vinhoRepository.pegaTodosVinhos();
    }

    @GetMapping("/{codigo}")
    public Vinho retornaVinhoPeloCodigo(@PathVariable Long codigo) {
        return vinhoRepository.pegaVinhoPorCodigo(codigo);
    }

    @PostMapping
    public void salvaVinho(@RequestBody Vinho vinho) {
        vinhoRepository.criaVinho(vinho);
    }

    @PutMapping("/{codigo}")
    public void alteraVinho(@PathVariable Long codigo, @RequestBody Vinho vinho) {
        vinhoRepository.atualizaVinho(codigo, vinho);
    }

    @DeleteMapping("/{codigo}")
    public void deletaVinho(@PathVariable Long codigo) {
        vinhoRepository.excluiVinho(codigo);
    }

}
