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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HISTORICO_MENTORIA")
public class HistoricoMentoria extends AbstractEntity<Long> {

	@Column(name = "ID_HISTORICO")
	private int _idHistorico;
	
	@Column(name = "ID_MENTORIA")
	private int _idMentoria;


}
