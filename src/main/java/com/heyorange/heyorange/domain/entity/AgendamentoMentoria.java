package com.heyorange.heyorange.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.heyorange.heyorange.constants.DatabaseConstants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "AGENDAMENTO_MENTORIA")
public class AgendamentoMentoria extends AbstractEntity<Long> {

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_ENVIO_EMAIL", referencedColumnName = "ID")
	private EnvioEmail envioEmail;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_CONFIRMACAO_MENTORIA", referencedColumnName = "ID")
	private ConfirmacaoMentoria confirmacaoMentoria;

}
