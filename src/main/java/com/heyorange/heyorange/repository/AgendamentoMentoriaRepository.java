package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.AgendamentoMentoria;

@Repository
public interface AgendamentoMentoriaRepository extends JpaRepository <AgendamentoMentoria,Long> {

}
