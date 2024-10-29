package br.dev.piece3D.pieceweb.service;

import br.dev.piece3D.pieceweb.model.Orcamento;
import br.dev.piece3D.pieceweb.repository.OrcamentoRepository; // Supondo que você tenha um repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public Orcamento save(Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    public List<Orcamento> findAll() {
        return orcamentoRepository.findAll();
    }

    public Orcamento findById(Long id) {
        return orcamentoRepository.findById(id).orElse(null);
    }

    public Orcamento update(Long id, Orcamento orcamentoDetails) {
        Optional<Orcamento> optionalOrcamento = orcamentoRepository.findById(id);
        if (optionalOrcamento.isPresent()) {
            Orcamento orcamento = optionalOrcamento.get();
            orcamento.setValor(orcamentoDetails.getValor());
            orcamento.setDataEntrega(orcamentoDetails.getDataEntrega());
            orcamento.setFormaPagamento(orcamentoDetails.getFormaPagamento());
            orcamento.setStatus(orcamentoDetails.getStatus());
            return orcamentoRepository.save(orcamento);
        }
        return null;
    }

    public boolean delete(Long id) {
        if (orcamentoRepository.existsById(id)) {
            orcamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
