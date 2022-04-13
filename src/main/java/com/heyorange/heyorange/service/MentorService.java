package com.heyorange.heyorange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.Mentor;
import com.heyorange.heyorange.repository.MentorRepository;

@Service
public class MentorService {

	@Autowired
	private MentorRepository mentorRepository;

	public Long create(final Mentor mentor) {

		return saveAndFlush(mentor).getId();

	}

	public Mentor findById(final Long id) {

		return mentorRepository.findById(id).orElseThrow();
	}

	public List<Mentor> listaMentores() {

		return mentorRepository.findAll();
	}

	private Mentor saveAndFlush(final Mentor mentor) {

		return mentorRepository.saveAndFlush(mentor);
	}

}
