package br.dev.piece3D.pieceweb.controller;

import br.dev.piece3D.pieceweb.model.Orcamento;
import br.dev.piece3D.pieceweb.service.OrcamentoService; // Supondo que você tenha um serviço para a lógica de negócios
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService; // Injetando o serviço

    // Criar um novo orçamento
    @PostMapping("/criar")
    public ResponseEntity<Orcamento> createOrcamento(@RequestBody Orcamento orcamento) {
        Orcamento createdOrcamento = orcamentoService.save(orcamento);
        return new ResponseEntity<>(createdOrcamento, HttpStatus.CREATED);
    }

    // Listar todos os orçamentos
    @GetMapping("/listar")
    public ResponseEntity<List<Orcamento>> getAllOrcamentos() {
        List<Orcamento> orcamentos = orcamentoService.findAll();
        return new ResponseEntity<>(orcamentos, HttpStatus.OK);
    }

    // Obter um orçamento por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Orcamento> getOrcamentoById(@PathVariable Long id) {
        Orcamento orcamento = orcamentoService.findById(id);
        if (orcamento != null) {
            return new ResponseEntity<>(orcamento, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Atualizar um orçamento existente
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Orcamento> updateOrcamento(@PathVariable Long id, @RequestBody Orcamento orcamentoDetails) {
        Orcamento updatedOrcamento = orcamentoService.update(id, orcamentoDetails);
        if (updatedOrcamento != null) {
            return new ResponseEntity<>(updatedOrcamento, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Deletar um orçamento por ID
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> deleteOrcamento(@PathVariable Long id) {
        if (orcamentoService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
