package com.heyorange.heyorange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.heyorange.heyorange.domain.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("from Pessoa p where p.nome =: nome")
	Optional<Pessoa> findByNome(@Param("nome") String nome);

}
