package com.heyorange.heyorange.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heyorange.heyorange.domain.dto.IdDTO;
import com.heyorange.heyorange.domain.dto.MentoriaDTO;
import com.heyorange.heyorange.domain.entity.Mentoria;
import com.heyorange.heyorange.domain.vo.MentoriaVO;
import com.heyorange.heyorange.service.MentoriaService;

@RestController
@RequestMapping("/mentoria")
public class MentoriaController extends BaseController {

	@Autowired
	private MentoriaService mentoriaService;

	public Long create(@RequestBody @Valid final MentoriaVO mentoriaVO) {

		return new IdDTO(mentoriaService.create(entityTypeConverter(mentoriaVO, Mentoria.class))).getId();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public MentoriaDTO findById(Long id) {

		return entityTypeConverter(mentoriaService.findById(id), MentoriaDTO.class);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MentoriaDTO> findAll(Long id) {

		return modelMapper.map(mentoriaService.findById(id), new TypeToken<List<MentoriaDTO>>() {}.getType());

	}

}
