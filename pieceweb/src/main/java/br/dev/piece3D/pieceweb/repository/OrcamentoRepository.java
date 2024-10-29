package br.dev.piece3D.pieceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.piece3D.pieceweb.model.Orcamento;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
}