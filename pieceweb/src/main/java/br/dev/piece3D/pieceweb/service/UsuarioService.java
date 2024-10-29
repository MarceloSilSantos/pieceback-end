package br.dev.piece3D.pieceweb.service;

import br.dev.piece3D.pieceweb.model.Usuario;
import br.dev.piece3D.pieceweb.repository.UsuarioRepository; // Supondo que você tenha um repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario update(Long id, Usuario usuarioDetails) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setUsername(usuarioDetails.getUsername());
            usuario.setSenha(usuarioDetails.getSenha());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setNome(usuarioDetails.getNome());
            usuario.setCpf_cnpj(usuarioDetails.getCpf_cnpj());
            usuario.setTelefone(usuarioDetails.getTelefone());
            usuario.setCep(usuarioDetails.getCep());
            usuario.setEndereco(usuarioDetails.getEndereco());
            usuario.setNumero(usuarioDetails.getNumero());
            usuario.setDescricaoPerfil(usuarioDetails.getDescricaoPerfil());
            usuario.setFotoPerfil(usuarioDetails.getFotoPerfil());
            usuario.setTipo(usuarioDetails.getTipo());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean delete(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
