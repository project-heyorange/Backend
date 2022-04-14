package com.heyorange.heyorange.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HABILIDADE_ITEM")
public class HabilidadeItem extends AbstractEntity<Long> {

	@Column(name = "ID_DOMINIO_HABILIDADES")
	private int idDominioHabilidades;

	@Column(name = "ID_DOMINIO_NIVEL_EXPERIENCIA")
	private int idDominioNivelExperiencia;

}
