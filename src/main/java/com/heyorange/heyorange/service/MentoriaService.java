package com.heyorange.heyorange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.Mentoria;
import com.heyorange.heyorange.repository.MentoriaRepository;

@Service
public class MentoriaService {

	@Autowired
	private MentoriaRepository mentoriaRepository;

	public Long create(final Mentoria mentoria) {

		return saveAndFlush(mentoria).getId();

	}

	public Mentoria findById(final Long id) {

		return mentoriaRepository.findById(id).orElseThrow();
	}

	public List<Mentoria> listaMentorias() {

		return mentoriaRepository.findAll();
	}

	private Mentoria saveAndFlush(final Mentoria mentoria) {

		return mentoriaRepository.saveAndFlush(mentoria);
	}

}
