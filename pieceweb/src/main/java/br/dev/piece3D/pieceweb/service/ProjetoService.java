package br.dev.piece3D.pieceweb.service;

import br.dev.piece3D.pieceweb.model.Projeto;
import br.dev.piece3D.pieceweb.repository.ProjetoRepository; // Supondo que você tenha um repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Projeto findById(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public Projeto update(Long id, Projeto projetoDetails) {
        Optional<Projeto> optionalProjeto = projetoRepository.findById(id);
        if (optionalProjeto.isPresent()) {
            Projeto projeto = optionalProjeto.get();
            projeto.setLargura(projetoDetails.getLargura());
            projeto.setComprimento(projetoDetails.getComprimento());
            projeto.setAltura(projetoDetails.getAltura());
            projeto.setDescricao(projetoDetails.getDescricao());
            projeto.setCaminhoArquivo(projetoDetails.getCaminhoArquivo());
            projeto.setDataFinalizacao(projetoDetails.getDataFinalizacao());
            projeto.setImagem(projetoDetails.getImagem());
            projeto.setMaterial(projetoDetails.getMaterial());
            projeto.setFollowup(projetoDetails.getFollowup());
            projeto.setStatusprojeto(projetoDetails.getStatusprojeto());
            return projetoRepository.save(projeto);
        }
        return null;
    }

    public boolean delete(Long id) {
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
