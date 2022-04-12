package com.heyorange.heyorange.domain.vo;

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
public class MentorVO extends AbstractVO<Long> {

	@NotNull
	private Byte[] foto;

	@NotNull
	private String descricaoExperiencia;

	@NotNull
	private PessoaVO Pessoa;

}
