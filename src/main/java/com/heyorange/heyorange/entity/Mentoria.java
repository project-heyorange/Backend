package com.heyorange.heyorange.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "MENTORIA")
public class Mentoria extends AbstractEntity<Long> {
	
	@Column(name = "ID_MENTORADO")
	private int idMentorado;

	@Column(name = "ID_MENTOR")
	private int idMentor;

	@Column(name = "ID_AGENDAMENTO_MENTORIA")
	private int idAgendamentoMentoria;

	@Column(name = "ID_DOMINIO_TIPO_MENTORIA")
	private int idDominioTipoMentoria;



}
