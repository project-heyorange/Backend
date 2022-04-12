package com.heyorange.heyorange.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import com.heyorange.heyorange.constants.DatabaseConstants;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "AGENDAMENTO_MENTORIA")
public class AgendamentoMentoria extends AbstractEntity<Long> {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENVIO_EMAIL", referencedColumnName = "ID")
	private EnvioEmail envioEmail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONFIRMACAO_MENTORIA", referencedColumnName = "ID")
	private ConfirmacaoMentoria confirmacaoMentoria;

}
