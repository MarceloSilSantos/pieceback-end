package br.dev.piece3D.pieceweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.dev.piece3D.pieceweb.model.Usuario;
import br.dev.piece3D.pieceweb.modelDTO.LoginDTO;
import br.dev.piece3D.pieceweb.repository.UsuarioRepository;

public class LoginController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping()
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO login) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(login.getEmail());

		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			// Verifica se a senha está correta
			
			System.err.println(login.getPassword());
			System.out.println(usuario.getSenha());
			if ((usuario.getSenha().equals(login.getPassword()))) {//passwordEncoder.matches
				LoginDTO loginDTO = new LoginDTO();
				loginDTO.setEmail(usuario.getEmail());
				loginDTO.setTipoUser(usuario.getTipo());
				loginDTO.setId(usuario.getId());

				return ResponseEntity.ok(loginDTO); // Retorna o usuário se a autenticação for bem-sucedida
			} else {
				return ResponseEntity.status(401).body(null); // Senha incorreta
			}
		} else {
			return ResponseEntity.status(404).body(null); // Usuário não encontrado
		}
	}

}



