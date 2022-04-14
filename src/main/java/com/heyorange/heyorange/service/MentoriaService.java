package com.heyorange.heyorange.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.AgendamentoMentoria;
import com.heyorange.heyorange.domain.entity.ConfirmacaoMentoria;
import com.heyorange.heyorange.domain.entity.Mentoria;
import com.heyorange.heyorange.enumeration.StatusAgendamentoMentoriaEnum;
import com.heyorange.heyorange.repository.MentoriaRepository;

@Service
public class MentoriaService extends AbstractMentoriaService {

	@Autowired
	private MentoriaRepository mentoriaRepository;

	public Long create(final Mentoria mentoria, StatusAgendamentoMentoriaEnum status) {

		return saveAndFlush(prepare(mentoria, status)).getId();
	}

	public Mentoria findById(final Long id) {

		return mentoriaRepository.findById(id).orElseThrow();
	}

	public List<Mentoria> listaMentorias() {

		return mentoriaRepository.findAll();
	}

	public List<Mentoria> listaMentoriasConfirmadas() {
		List<Mentoria> mentorias = mentoriaRepository.findAll();
		List<Mentoria> mentoriasConfirmadas = new ArrayList<>();

		for (Mentoria mentoria : mentorias) {

			if (mentoria.getAgendamentoMentoria().getConfirmacaoMentoria() //
					.getIdDominoStatusMentoria() == StatusAgendamentoMentoriaEnum.CONFIRMADA.getId()) {

				mentoriasConfirmadas.add(mentoria);
			}
		}

		return mentoriasConfirmadas;
	}

	private Mentoria saveAndFlush(final Mentoria mentoria) {

		return mentoriaRepository.saveAndFlush(mentoria);
	}

	public HttpStatus cancelarMentoria(final Long id, StatusAgendamentoMentoriaEnum status) {
		atualizarMentoria(id, status);

		return HttpStatus.ACCEPTED;
	}

	public HttpStatus confirmarMentoria(final Long id, StatusAgendamentoMentoriaEnum status) {
		atualizarMentoria(id, status);

		return HttpStatus.OK;
	}

	private void atualizarMentoria(final Long id, StatusAgendamentoMentoriaEnum statusAgendamento) {
		Mentoria mentoria = mentoriaRepository.findById(id).orElseThrow();
		mentoria.setAgendamentoMentoria(AgendamentoMentoria.builder() //
				.confirmacaoMentoria(ConfirmacaoMentoria.builder() //
						.idDominoStatusMentoria(statusAgendamento.getId()) //
						.build()) //
				.build()); //
		mentoriaRepository.save(mentoria);
	}

	public List<Mentoria> listaMentoriasCanceladas() {
		List<Mentoria> mentorias = mentoriaRepository.findAll();
		List<Mentoria> mentoriasConfirmadas = new ArrayList<>();

		for (Mentoria mentoria : mentorias) {

			if (mentoria.getAgendamentoMentoria().getConfirmacaoMentoria() //
					.getIdDominoStatusMentoria() == StatusAgendamentoMentoriaEnum.CANCELADA.getId()) {

				mentoriasConfirmadas.add(mentoria);
			}
		}

		return mentoriasConfirmadas;
	}

}
