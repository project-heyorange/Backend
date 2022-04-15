package com.heyorange.heyorange.domain.vo;

import java.sql.Timestamp;

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
public class NovaMentoriaVO extends AbstractVO<Long> {

	@NotNull
	private Long idMentorado;

	@NotNull
	private Long idMentor;

	private Timestamp hora;
}
