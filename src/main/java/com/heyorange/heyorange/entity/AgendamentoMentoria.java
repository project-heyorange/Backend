package com.heyorange.heyorange.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.heyorange.heyorange.constants.DatabaseConstants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "AGENDAMENTO_MENTORIA")
public class AgendamentoMentoria extends AbstractEntity<Long> {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENVIO_EMAIL", referencedColumnName = "ID")
	private EnvioEmail envioEmail;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONFIRMACAO_MENTORIA", referencedColumnName = "ID")
	private ConfirmacaoMentoria confirmacaoMentoria;

}
