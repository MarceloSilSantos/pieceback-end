package br.dev.piece3D.pieceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.piece3D.pieceweb.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    // Métodos adicionais, se necessário
	
	//Optional<List<Usuario>> findByUsuario_Id(Long id);// Quando logar como Cliente
	
	//Optional<List<Usuario>> findByUsuario_(Long id);// Quando logar como Projtista I - enxerga os próprios projetos "em andamento"
	
	//Optional<List<Usuario>> findByUsuario_Id(Long id);// Quando logar como Projtista II - enxerga os projetos "não iniciados"
	
	
	
}