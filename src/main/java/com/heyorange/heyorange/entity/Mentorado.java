package com.heyorange.heyorange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "MENTORADO")
public class Mentorado extends AbstractEntity<Long> {
	
	@Lob
	@Column(name = "FOTO")
	private byte[] foto;

	@Column(name = "DESCRICAO_EXPERIENCIA")
	private String descricaoExperiencia;

	@Column(name = "ID_PESSOA")
	private int idPessoa;


}
