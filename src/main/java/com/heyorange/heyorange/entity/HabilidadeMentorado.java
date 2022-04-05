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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HABILIDADE_MENTORADO")
public class HabilidadeMentorado extends AbstractEntity<Long> {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_HABILIDADE_ITEM", referencedColumnName = "ID")
	private HabilidadeItem habilidadeItem;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENTORADO", referencedColumnName = "ID")
	private Mentorado mentorado;

}