package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.domain.entity.Mentorado;

@Repository
public interface MentoradoRepository extends JpaRepository<Mentorado, Long> {

}
