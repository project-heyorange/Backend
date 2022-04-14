package com.heyorange.heyorange.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.HabilidadeDesejada;
import com.heyorange.heyorange.domain.entity.Mentorado;
import com.heyorange.heyorange.domain.vo.HabilidadeDesejadaVO;
import com.heyorange.heyorange.exception.NotFoundException;
import com.heyorange.heyorange.repository.HabilidadeDesejadaRepository;
import com.heyorange.heyorange.repository.MentoradoRepository;

@Service
public class MentoradoService {

	@Autowired
	private MentoradoRepository mentoradoRepository;

	@Autowired
	private HabilidadeDesejadaRepository habilidadeDesejadaRepository;

	public Long create(final Mentorado mentorado) {

		return saveAndFlush(mentorado).getId();

	}

	public void create(@Valid HabilidadeDesejadaVO habilidadeDesejadaVO, Long idMentorado) {
		for (Integer habilidade : habilidadeDesejadaVO.getHabilidades()) {

			HabilidadeDesejada habilidadeDesejada = HabilidadeDesejada //
					.builder() //
					.idDominioHabilidades(habilidade) //
					.idMentorado(idMentorado).build();

			habilidadeDesejadaRepository.saveAndFlush(habilidadeDesejada);
		}

	}

	public Mentorado findById(final Long id) throws NotFoundException {
		try {
			return mentoradoRepository.findById(id).get();
		} catch (Exception e) {

			throw new NotFoundException();
		}
	}

	public List<Mentorado> listarMentorados() {

		return mentoradoRepository.findAll();
	}

	public Mentorado findByNome(String nome) throws NotFoundException {
		try {
			return mentoradoRepository.findByNome(nome).get();
		} catch (Exception e) {

			throw new NotFoundException();
		}
	}

	private Mentorado saveAndFlush(final Mentorado mentorado) {

		return mentoradoRepository.saveAndFlush(mentorado);
	}

}
