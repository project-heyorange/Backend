package com.heyorange.heyorange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.Pessoa;
import com.heyorange.heyorange.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Long create(final Pessoa pessoa) {

		return saveAndFlush(pessoa).getId();

	}

	public Pessoa findById(final Long id) {

		return pessoaRepository.findById(id).orElseThrow();
	}

	public List<Pessoa> listaPessoas() {

		return pessoaRepository.findAll();
	}

	public Pessoa findByNome(String nome) {

		return pessoaRepository.findByNome(nome).orElseThrow();
	}

	private Pessoa saveAndFlush(final Pessoa pessoa) {

		return pessoaRepository.saveAndFlush(pessoa);
	}

}
