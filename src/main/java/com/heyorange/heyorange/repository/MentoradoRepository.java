package com.heyorange.heyorange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.domain.entity.Mentorado;

@Repository
public interface MentoradoRepository extends JpaRepository<Mentorado, Long> {

	@Query("from Mentorado m join m.pessoa u join fetch m.pessoa where u.nome = :nome")
	Optional<Mentorado> findByNome(@Param("nome") String nome);

}
