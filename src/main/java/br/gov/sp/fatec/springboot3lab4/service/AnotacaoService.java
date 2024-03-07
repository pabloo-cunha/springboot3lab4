package br.gov.sp.fatec.springboot3lab4.service;

import br.gov.sp.fatec.springboot3lab4.entitiy.Anotacao;
import br.gov.sp.fatec.springboot3lab4.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    private List<Anotacao> buscarTodasAnotacoes(){
        return anotacaoRepository.findAll();
    }

    private Anotacao salvarAnotacao(Anotacao anotacao){
        if (anotacao == null ||
            anotacao.getTexto() == null ||
            anotacao.getTexto().isBlank() ||
            anotacao.getUsuario() == null || anotacao.getUsuario().getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }
        if (anotacao.getDataHora() == null){
            anotacao.setDataHora(LocalDateTime.now());
        }
        anotacao.setUsuario(
                usuarioService.buscarUsuarioPorId(anotacao.getUsuario().getId())
        );
        return anotacaoRepository.save(anotacao);
    }
    private Anotacao buscarAnotacaoPorId(Long id){
        return anotacaoRepository.findById(id).get();
    }
}
