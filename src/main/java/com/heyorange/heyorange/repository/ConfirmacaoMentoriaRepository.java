package com.heyorange.heyorange.repository;

import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.ConfirmacaoMentoria;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ConfirmacaoMentoriaRepository extends JpaRepository<ConfirmacaoMentoria,Long> {

}
