package com.heyorange.heyorange.domain.dto;

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

	private String nome;

	private String senha;

	private MentorDTO mentor;

	private MentoradoDTO mentorado;

	private int idDominioStatusUsuario;

	private int idDominioTipoUsuario;

}
