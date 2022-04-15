package com.heyorange.heyorange.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heyorange.heyorange.domain.dto.IdDTO;
import com.heyorange.heyorange.domain.dto.MentorDTO;
import com.heyorange.heyorange.domain.dto.MentoradoDTO;
import com.heyorange.heyorange.domain.entity.Mentorado;
import com.heyorange.heyorange.domain.vo.HabilidadeDesejadaVO;
import com.heyorange.heyorange.domain.vo.MentoradoVO;
import com.heyorange.heyorange.exception.NotFoundException;
import com.heyorange.heyorange.service.MentoradoService;

@RestController
@RequestMapping("/mentorado")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MentoradoController extends BaseController {

	@Autowired
	private MentoradoService mentoradoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody @Valid final MentoradoVO mentoradoVO) {

		return new IdDTO(mentoradoService.create(entityTypeConverter(mentoradoVO, Mentorado.class))).getId();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{id}/habilidade")
	public void create(@RequestBody @Valid final HabilidadeDesejadaVO habilidadeDesejadaVO,
			@PathVariable("id") final Long id) {

		mentoradoService.create(habilidadeDesejadaVO, id);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MentoradoDTO findById(@PathVariable("id") Long id) throws NotFoundException {

		return entityTypeConverter(mentoradoService.findById(id), MentoradoDTO.class);
	}

	@GetMapping("/nome/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public MentorDTO findByNome(@PathVariable String nome) throws NotFoundException {

		return entityTypeConverter(mentoradoService.findByNome(nome), MentorDTO.class);

	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MentoradoDTO> listarMentorados() {

		return modelMapper.map(mentoradoService.listarMentorados(), new TypeToken<List<MentoradoDTO>>() {
		}.getType());
	}

}
