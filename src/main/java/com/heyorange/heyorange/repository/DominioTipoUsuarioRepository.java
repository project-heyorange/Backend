package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.domain.entity.DominioTipoUsuario;

@Repository
public interface DominioTipoUsuarioRepository extends JpaRepository<DominioTipoUsuario, Long> {

}
