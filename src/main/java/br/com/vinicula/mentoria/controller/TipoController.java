package br.com.vinicula.mentoria.controller;

import br.com.vinicula.mentoria.model.Tipo;
import br.com.vinicula.mentoria.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {

    @Autowired
    private TipoRepository tipoRepository;

    @GetMapping
    public List<Tipo> retornaTodosTipos() {
        return tipoRepository.pegaTodosTipos();
    }

    @GetMapping("/{codigo}")
    public Tipo retornaTipoPeloCodigo(@PathVariable Long codigo) {
        return tipoRepository.pegaTipoPorCodigo(codigo);
    }

    @PostMapping
    public void salvaTipo(@RequestBody Tipo tipo) {
        tipoRepository.criaTipo(tipo);
    }

    @PutMapping("/{codigo}")
    public void alteraTipo(@PathVariable Long codigo, @RequestBody Tipo tipo) {
        tipoRepository.atualizaTipo(codigo, tipo);
    }

    @DeleteMapping("/{codigo}")
    public void deletaTipo(@PathVariable Long codigo) {
        tipoRepository.excluiTipo(codigo);
    }

}
