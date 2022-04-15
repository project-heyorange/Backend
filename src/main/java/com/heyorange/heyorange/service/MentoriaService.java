package com.heyorange.heyorange.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.AgendamentoMentoria;
import com.heyorange.heyorange.domain.entity.ConfirmacaoMentoria;
import com.heyorange.heyorange.domain.entity.Historico;
import com.heyorange.heyorange.domain.entity.HistoricoMentoria;
import com.heyorange.heyorange.domain.entity.Mentoria;
import com.heyorange.heyorange.domain.entity.NovaMentoria;
import com.heyorange.heyorange.domain.vo.NovaMentoriaVO;
import com.heyorange.heyorange.enumeration.StatusAgendamentoMentoriaEnum;
import com.heyorange.heyorange.repository.HistoricoMentoriaRepository;
import com.heyorange.heyorange.repository.MentoriaRepository;
import com.heyorange.heyorange.repository.NovaMentoriaRepository;

@Service
public class MentoriaService extends AbstractMentoriaService {

	@Autowired
	private MentoriaRepository mentoriaRepository;
	
	@Autowired
	private NovaMentoriaRepository novaMentoriaRepository;

	@Autowired
	private HistoricoMentoriaRepository historicoMentoriaRepository;

	public Long create(final Mentoria mentoria, StatusAgendamentoMentoriaEnum status) {

		HistoricoMentoria historicoMentoria = HistoricoMentoria.builder() //
				.historico(Historico.builder() //
						.dataAlteracao(new Timestamp(System.currentTimeMillis())) //
						.dataCriacao(new Timestamp(System.currentTimeMillis())) //
						.idDominioTipoAcao(1) //
						.build())
				.mentoria(mentoria).build();

		historicoMentoriaRepository.saveAndFlush(historicoMentoria);

		return saveAndFlush(prepare(mentoria, status)).getId();
	}

	public Long criarMentoriaHorario(final NovaMentoriaVO novaMentoriaVO) {

		Timestamp hora = novaMentoriaVO.getHora();

		if (Objects.isNull(hora)) {
			hora = new Timestamp(System.currentTimeMillis());
		}

		NovaMentoria novaMentoria = NovaMentoria //
				.builder() //
				.dataMentoria(hora) //
				.idMentor(novaMentoriaVO.getIdMentor()) //
				.idMentorado(novaMentoriaVO.getIdMentorado()) //
				.build();

		return novaMentoriaRepository.saveAndFlush(novaMentoria).getId();
	}

	public NovaMentoria findById(final Long id) {

		return novaMentoriaRepository.findById(id).orElseThrow();
	}

	public List<NovaMentoria> listaMentorias() {

		return novaMentoriaRepository.findAll();
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
