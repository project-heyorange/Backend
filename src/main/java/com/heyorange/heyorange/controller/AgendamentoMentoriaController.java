package com.heyorange.heyorange.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heyorange.heyorange.domain.dto.IdDTO;
import com.heyorange.heyorange.domain.dto.MentoriaDTO;
import com.heyorange.heyorange.domain.entity.Mentoria;
import com.heyorange.heyorange.domain.vo.MentoriaVO;
import com.heyorange.heyorange.enumeration.StatusAgendamentoMentoriaEnum;
import com.heyorange.heyorange.service.MentoriaService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoMentoriaController extends BaseController {

	@Autowired
	private MentoriaService mentoriaService;

	@PostMapping("/mentoria")
	public Long create(@RequestBody @Valid final MentoriaVO mentoriaVO) {

		return new IdDTO(mentoriaService.create(entityTypeConverter(mentoriaVO, Mentoria.class),
				StatusAgendamentoMentoriaEnum.AGENDADA)).getId();
	}

	@GetMapping("/mentoria/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MentoriaDTO buscarMentoria(@PathVariable("id") Long id) {

		return entityTypeConverter(mentoriaService.findById(id), MentoriaDTO.class);
	}

	@PutMapping("/mentoria/{id}/confirmar")
	public HttpStatus agendarMentoria(@PathVariable("id") Long id) {

		return mentoriaService.confirmarMentoria(id, StatusAgendamentoMentoriaEnum.CONFIRMADA);
	}

	@PutMapping("/mentoria/{id}/cancelar")
	public HttpStatus cancelarMentoria(@PathVariable("id") Long id) {

		return mentoriaService.confirmarMentoria(id, StatusAgendamentoMentoriaEnum.CANCELADA);
	}

	@GetMapping("/mentoria")
	@ResponseStatus(HttpStatus.OK)
	public List<MentoriaDTO> listarTodasMentorias() {

		return modelMapper.map(mentoriaService.listaMentorias(), new TypeToken<List<MentoriaDTO>>() {
		}.getType());

	}

	@GetMapping("/mentoria/confirmadas")
	@ResponseStatus(HttpStatus.OK)
	public List<MentoriaDTO> listarMentoriasConfirmadas() {

		return modelMapper.map(mentoriaService.listaMentoriasConfirmadas(), new TypeToken<List<MentoriaDTO>>() {
		}.getType());

	}

	@GetMapping("/mentoria/canceladas")
	@ResponseStatus(HttpStatus.OK)
	public List<MentoriaDTO> listarMentoriasCanceladas() {

		return modelMapper.map(mentoriaService.listaMentoriasCanceladas(), new TypeToken<List<MentoriaDTO>>() {
		}.getType());

	}

}
