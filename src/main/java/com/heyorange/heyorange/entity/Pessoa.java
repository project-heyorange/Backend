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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "PESSOA")
public class Pessoa extends AbstractEntity <Long>{

	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "IDADE")
	private Integer idade;
	
	@Column(name = "EMAIL")
	private String email;
	


}
