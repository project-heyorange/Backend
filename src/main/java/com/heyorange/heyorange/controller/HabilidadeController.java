package com.heyorange.heyorange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heyorange.heyorange.domain.entity.DominioHabilidades;
import com.heyorange.heyorange.domain.entity.HabilidadeDesejada;
import com.heyorange.heyorange.domain.entity.HabilidadeMentor;
import com.heyorange.heyorange.domain.entity.HabilidadeMentorado;
import com.heyorange.heyorange.service.HabilidadeService;

@RestController
@RequestMapping("/tipo-habilidades")
public class HabilidadeController extends BaseController {

	@Autowired
	private HabilidadeService habilidadeService;

	@GetMapping("/desejada/{id}")
	@ResponseStatus(HttpStatus.OK)
	public HabilidadeDesejada findByHabilidadeDesejadaId(@PathVariable("id") Long id) {

		return habilidadeService.findByHabilidadeDesejadaId(id);
	}

	@GetMapping("/desejada")
	@ResponseStatus(HttpStatus.OK)
	public List<HabilidadeDesejada> listarHabilidadesDesejadas() {

		return habilidadeService.listarHabilidadesDesejadas();
	}

	@GetMapping("/mentor/{id}")
	@ResponseStatus(HttpStatus.OK)
	public HabilidadeMentor findByHabilidadeMentorId(@PathVariable("id") Long id) {

		return habilidadeService.findByHabilidadeMentorId(id);
	}

	@GetMapping("/mentor/")
	@ResponseStatus(HttpStatus.OK)
	public List<HabilidadeMentor> listarHabilidadesMentor() {

		return habilidadeService.listarHabilidadesMentor();
	}

	@GetMapping("/mentorado/{id}")
	@ResponseStatus(HttpStatus.OK)
	public HabilidadeMentorado findByHabilidadeMentoradoId(@PathVariable("id") Long id) {

		return habilidadeService.findByHabilidadeMentoradoId(id);
	}

	@GetMapping("/mentorado")
	@ResponseStatus(HttpStatus.OK)
	public List<HabilidadeMentorado> listarHabilidadesMentorado() {

		return habilidadeService.listarHabilidadesMentorado();
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<DominioHabilidades> listarHabilidadesCadastradas() {

		return habilidadeService.listarHabilidadesCadastradas();
	}

}
