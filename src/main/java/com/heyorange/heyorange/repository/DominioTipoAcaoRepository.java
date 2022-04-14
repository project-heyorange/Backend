package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.domain.entity.DominioTipoAcao;

@Repository
public interface DominioTipoAcaoRepository extends JpaRepository<DominioTipoAcao, Long> {

}
