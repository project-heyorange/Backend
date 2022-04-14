package com.heyorange.heyorange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.domain.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

	@Query("from Mentor m join m.pessoa u join fetch m.pessoa where u.nome = :nome")
	Optional<Mentor> findByNome(@Param("nome") String nome);

}
