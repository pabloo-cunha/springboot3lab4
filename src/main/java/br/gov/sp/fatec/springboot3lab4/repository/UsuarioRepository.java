package br.gov.sp.fatec.springboot3lab4.repository;

import br.gov.sp.fatec.springboot3lab4.entitiy.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
