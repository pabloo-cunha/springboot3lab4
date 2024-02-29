package br.gov.sp.fatec.springboot3lab4.service;

import br.gov.sp.fatec.springboot3lab4.entitiy.Usuario;
import br.gov.sp.fatec.springboot3lab4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario buscarUsuarioPorId(Long id){

        Optional<Usuario> byId = usuarioRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
    }

    public Usuario novoUsuario(String nome, String senha){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuarioRepository.save(usuario);
        return usuario;
    }
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }
}
