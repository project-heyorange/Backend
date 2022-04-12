package com.heyorange.heyorange.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HABILIDADE_DESEJADA")
public class HabilidadeDesejada extends AbstractEntity<Long> {

	@Column(name = "ID_DOMINIO_HABILIDADES")
	private int idDominioHabilidades;

	@Column(name = "ID_MENTORADO")
	private Long idMentorado;

}
