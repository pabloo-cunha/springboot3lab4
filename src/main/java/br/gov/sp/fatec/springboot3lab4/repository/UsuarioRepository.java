package br.gov.sp.fatec.springboot3lab4.repository;

import br.gov.sp.fatec.springboot3lab4.entitiy.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

}
