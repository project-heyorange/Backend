package com.heyorange.heyorange.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "MENTOR")
public class Mentor extends AbstractEntity<Long> {
	
	@Lob
	@Column(name = "FOTO")
	private byte[] foto;

	@Column(name = "DESCRICAO_EXPERIENCIA")
	private String descricaoExperiencia;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
	private Pessoa pessoa;

}
