package com.heyorange.heyorange.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class AbstractDominio<I extends Serializable> {

	@Id
	@Column(name = "ID")
	protected I id;

	@Column(name = "DESCRICAO")
	protected String descricao;

	@Column(name = "NUMERO_ORDEM")
	protected int numeroOrdem;

}
