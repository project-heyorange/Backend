package com.heyorange.heyorange.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO extends AbstractDTO<Long> {

	private String nome;

	private String senha;

	private MentorDTO mentor;

	private MentoradoDTO mentorado;

	private int idDominioStatusUsuario;

	private int idDominioTipoUsuario;

}
