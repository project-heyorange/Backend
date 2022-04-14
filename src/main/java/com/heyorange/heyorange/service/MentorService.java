package com.heyorange.heyorange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.Mentor;
import com.heyorange.heyorange.exception.NotFoundException;
import com.heyorange.heyorange.repository.MentorRepository;

@Service
public class MentorService {

	@Autowired
	private MentorRepository mentorRepository;

	public Long create(final Mentor mentor) {

		return saveAndFlush(mentor).getId();

	}

	public Mentor findById(final Long id) throws NotFoundException {
		try {
			return mentorRepository.findById(id).get();
		} catch (Exception e) {
			throw new NotFoundException();
		}
	}

	public List<Mentor> listaMentores() {

		return mentorRepository.findAll();
	}

	public Mentor findByNome(String nome) throws NotFoundException {
		try {
			return mentorRepository.findByNome(nome).get();
		} catch (Exception e) {
			throw new NotFoundException();
		}
	}

	private Mentor saveAndFlush(final Mentor mentor) {

		return mentorRepository.saveAndFlush(mentor);
	}

}
