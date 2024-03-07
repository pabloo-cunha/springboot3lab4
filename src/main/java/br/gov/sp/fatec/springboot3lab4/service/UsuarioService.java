package br.gov.sp.fatec.springboot3lab4.service;

import br.gov.sp.fatec.springboot3lab4.entitiy.Autorizacao;
import br.gov.sp.fatec.springboot3lab4.entitiy.Usuario;
import br.gov.sp.fatec.springboot3lab4.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springboot3lab4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AutorizacaoRepository autorizacaoRepository;

    public Usuario buscarUsuarioPorId(Long id){

        Optional<Usuario> byId = usuarioRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
    }

    public Usuario novoUsuario(Usuario usuario){

        if (usuario == null ||
            usuario.getNome() == null ||
            usuario.getNome().isBlank() ||
            usuario.getSenha() == null ||
            usuario.getSenha().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }
        if (usuario.getAutorizacoes() != null && !usuario.getAutorizacoes().isEmpty()){

            usuario.getAutorizacoes().forEach(autorizacao -> {
                Set<Autorizacao> autorizacoes = new HashSet<>();
                for(Autorizacao aut : usuario.getAutorizacoes()){
                    autorizacoes.add(buscarAutorizacaoPorId(aut.getId()));
                }}
            );
        }
        return usuario;
    }

    public Autorizacao buscarAutorizacaoPorId(Long id){
        Optional<Autorizacao> byId = autorizacaoRepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
    }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autorização não encontrada");
        }
    }
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }
}
