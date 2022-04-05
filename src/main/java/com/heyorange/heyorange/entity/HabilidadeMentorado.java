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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HABILIDADE_MENTORADO")
public class HabilidadeMentorado extends AbstractEntity<Long> {
	@Column(name = "ID_HABILIDADE_ITEM")	
	private int idHabilidadeItem;

	@Column(name = "ID_MENTORADO")	
	private int idMentorado;


}