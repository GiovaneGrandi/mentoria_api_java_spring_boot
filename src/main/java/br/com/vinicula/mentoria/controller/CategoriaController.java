package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Categoria;
import br.com.vinicula.mentoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository CategoriaRepository;

    @GetMapping
    public List<Categoria> retornaTodasCategorias() {
        return CategoriaRepository.pegaTodasCategorias();
    }

    @GetMapping("/{codigo}")
    public Categoria retornaCategoriaPeloCodigo(@PathVariable Long codigo) {
        return CategoriaRepository.pegaCategoriaPorCodigo(codigo);
    }

    @PostMapping
    public void salvaCategoria(@RequestBody Categoria categoria) {
        CategoriaRepository.criaCategoria(categoria);
    }

    @PutMapping("/{codigo}")
    public void alteraCategoria(@PathVariable Long codigo, @RequestBody Categoria categoria) {
        CategoriaRepository.atualizaCategoria(codigo, categoria);
    }

    @DeleteMapping("/{codigo}")
    public void deletaCategoria(@PathVariable Long codigo) {
        CategoriaRepository.excluiCategoria(codigo);
    }

}
