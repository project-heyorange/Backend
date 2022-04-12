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
public class HabilidadeDesejadaVO extends AbstractVO<Long> {

	@NotNull
	private List<Integer> habilidades;

}
