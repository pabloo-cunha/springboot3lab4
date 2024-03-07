package br.gov.sp.fatec.springboot3lab4.repository;

import br.gov.sp.fatec.springboot3lab4.entitiy.Autorizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
}
