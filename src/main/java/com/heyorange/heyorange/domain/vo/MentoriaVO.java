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
public class MentoriaVO extends AbstractVO<Long> {

	private Integer idMentorado;

	private Integer idMentor;

	@NotNull
	private Integer idDominioTipoMentoria;
}
