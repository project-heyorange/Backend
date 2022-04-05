package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.DominioTipoEmail;

@Repository
public interface DominioTipoEmailRepository extends JpaRepository<DominioTipoEmail, Long> {
}
