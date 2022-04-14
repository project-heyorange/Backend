package com.heyorange.heyorange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.DominioHabilidades;
import com.heyorange.heyorange.domain.entity.HabilidadeDesejada;
import com.heyorange.heyorange.domain.entity.HabilidadeMentor;
import com.heyorange.heyorange.domain.entity.HabilidadeMentorado;
import com.heyorange.heyorange.repository.DominioHabilidadesRepository;
import com.heyorange.heyorange.repository.HabilidadeDesejadaRepository;
import com.heyorange.heyorange.repository.HabilidadeMentorRepository;
import com.heyorange.heyorange.repository.HabilidadeMentoradoRepository;

@Service
public class HabilidadeService {

	@Autowired
	private HabilidadeDesejadaRepository habilidadeDesejadaRepository;

	@Autowired
	private HabilidadeMentoradoRepository habilidadeMentoradoRepository;

	@Autowired
	private HabilidadeMentorRepository habilidadeMentorRepository;

	@Autowired
	private DominioHabilidadesRepository dominioHabilidadeRepository;

	public HabilidadeDesejada findByHabilidadeDesejadaId(final Long id) {

		return habilidadeDesejadaRepository.findById(id).orElseThrow();
	}

	public HabilidadeMentorado findByHabilidadeMentoradoId(final Long id) {

		return habilidadeMentoradoRepository.findById(id).orElseThrow();
	}

	public HabilidadeMentor findByHabilidadeMentorId(final Long id) {

		return habilidadeMentorRepository.findById(id).orElseThrow();
	}

	public List<HabilidadeDesejada> listarHabilidadesDesejadas() {

		return habilidadeDesejadaRepository.findAll();
	}

	public List<HabilidadeMentorado> listarHabilidadesMentorado() {

		return habilidadeMentoradoRepository.findAll();
	}

	public List<HabilidadeMentor> listarHabilidadesMentor() {

		return habilidadeMentorRepository.findAll();
	}

	public HabilidadeDesejada saveAndFlushHabilidadeDesejada(final HabilidadeDesejada habilidade) {

		return habilidadeDesejadaRepository.saveAndFlush(habilidade);
	}

	public HabilidadeMentor saveAndFlushMentor(final HabilidadeMentor habilidade) {

		return habilidadeMentorRepository.saveAndFlush(habilidade);
	}

	public HabilidadeMentorado saveAndFlushMentorado(final HabilidadeMentorado habilidade) {

		return habilidadeMentoradoRepository.saveAndFlush(habilidade);
	}

	public List<DominioHabilidades> listarHabilidadesCadastradas() {

		return dominioHabilidadeRepository.findAll();
	}
}
