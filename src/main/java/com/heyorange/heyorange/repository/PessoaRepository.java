package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyorange.heyorange.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
