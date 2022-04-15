package com.heyorange.heyorange.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.heyorange.heyorange.domain.entity.AgendamentoMentoria;
import com.heyorange.heyorange.domain.entity.HistoricoMentoria;
import com.heyorange.heyorange.domain.entity.Mentoria;

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
public class MentoriaDTO {

	private Long idMentorado;

	private Long idMentor;

	private int idDominioTipoMentoria;
	
	private AgendamentoMentoria agendamentoMentoria;
	
}
