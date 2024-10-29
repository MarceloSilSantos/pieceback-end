package br.dev.piece3D.pieceweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.piece3D.pieceweb.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);
}
