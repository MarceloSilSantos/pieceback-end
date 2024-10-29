package br.dev.piece3D.pieceweb.controller;

import br.dev.piece3D.pieceweb.model.Projeto;
import br.dev.piece3D.pieceweb.service.ProjetoService; // Supondo que você tenha um serviço para a lógica de negócios
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService; // Injetando o serviço

    // Criar um novo projeto
    @PostMapping("/criar")
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto) {
        Projeto createdProjeto = projetoService.save(projeto);
        return new ResponseEntity<>(createdProjeto, HttpStatus.CREATED);
    }

    // Listar todos os projetos
    @GetMapping("/listar")
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        List<Projeto> projetos = projetoService.findAll();
        return new ResponseEntity<>(projetos, HttpStatus.OK);
    }

    // Obter um projeto por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
        Projeto projeto = projetoService.findById(id);
        if (projeto != null) {
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Atualizar um projeto existente
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projetoDetails) {
        Projeto updatedProjeto = projetoService.update(id, projetoDetails);
        if (updatedProjeto != null) {
            return new ResponseEntity<>(updatedProjeto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Deletar um projeto por ID
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> deleteProjeto(@PathVariable Long id) {
        if (projetoService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
