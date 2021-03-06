package com.heyorange.heyorange.domain.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

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
public class UsuarioVO extends AbstractVO<Long> {

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@NotNull
	private String senha;

	@NotNull
	private String nivelExperiencia;

	@NotNull
	private String area;

	private List<String> habilidade;

}
