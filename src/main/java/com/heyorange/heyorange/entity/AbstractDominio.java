package com.heyorange.heyorange.entity;

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
	protected String descricao;
	protected int numeroOrdem;

}
