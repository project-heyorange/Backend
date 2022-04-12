package com.heyorange.heyorange.domain.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroUsuarioVO {

	private String nome;

	private Boolean mentor;

	private Boolean mentorado;

	private List<Integer> habilidades;

}
