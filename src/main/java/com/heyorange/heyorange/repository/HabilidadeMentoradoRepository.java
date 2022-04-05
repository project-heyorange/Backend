package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.HabilidadeMentorado;

@Repository
public interface HabilidadeMentoradoRepository extends JpaRepository<HabilidadeMentorado,Long> {
	

}
