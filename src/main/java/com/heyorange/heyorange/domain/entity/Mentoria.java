package com.heyorange.heyorange.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "MENTORIA")
public class Mentoria extends AbstractEntity<Long> {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENTORADO", referencedColumnName = "ID")
	private Mentorado mentorado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENTOR", referencedColumnName = "ID")
	private Mentor mentor;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_AGENDAMENTO_MENTORIA", referencedColumnName = "ID")
	private AgendamentoMentoria agendamentoMentoria;

	@Column(name = "ID_DOMINIO_TIPO_MENTORIA")
	private int idDominioTipoMentoria;

}
