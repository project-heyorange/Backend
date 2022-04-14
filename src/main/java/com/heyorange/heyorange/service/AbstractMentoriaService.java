package com.heyorange.heyorange.service;

import com.heyorange.heyorange.domain.entity.AgendamentoMentoria;
import com.heyorange.heyorange.domain.entity.ConfirmacaoMentoria;
import com.heyorange.heyorange.domain.entity.Mentoria;
import com.heyorange.heyorange.enumeration.StatusAgendamentoMentoriaEnum;

public abstract class AbstractMentoriaService {

	protected Mentoria prepare(Mentoria mentoria, StatusAgendamentoMentoriaEnum status) {

		mentoria.setAgendamentoMentoria(AgendamentoMentoria.builder() //
				.confirmacaoMentoria(ConfirmacaoMentoria.builder() //
						.idDominoStatusMentoria(status.getId()) //
						.build()) //
				.build()); //

		return mentoria;
	}

}
