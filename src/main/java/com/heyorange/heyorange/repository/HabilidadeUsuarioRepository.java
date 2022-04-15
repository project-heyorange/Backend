package com.heyorange.heyorange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.domain.entity.HabilidadeUsuario;

@Repository
public interface HabilidadeUsuarioRepository extends JpaRepository<HabilidadeUsuario, Long> {

	List<HabilidadeUsuario> findByidUsuario(Long idUsuario);

}
