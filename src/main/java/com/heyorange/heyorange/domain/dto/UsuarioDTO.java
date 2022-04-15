package com.heyorange.heyorange.domain.dto;

import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO extends AbstractDTO<Long> {

	private Long id;
	
	private String nome;

	private String senha;
	
	private String area;
	
	private String nivelExperiencia;
	
	private String email;	
	
	private List<String> habilidades;

}
