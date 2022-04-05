package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.DominioStatusUsuario;

@Repository
public interface DominioStatusUsuarioRepository extends JpaRepository<DominioStatusUsuario, Long> {

}