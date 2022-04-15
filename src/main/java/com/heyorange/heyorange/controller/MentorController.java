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
import com.heyorange.heyorange.domain.entity.Mentor;
import com.heyorange.heyorange.domain.vo.MentorVO;
import com.heyorange.heyorange.exception.NotFoundException;
import com.heyorange.heyorange.service.MentorService;

@RestController
@RequestMapping("/mentor")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class MentorController extends BaseController {

	@Autowired
	private MentorService mentorService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody @Valid final MentorVO mentorVO) {

		return new IdDTO(mentorService.create(entityTypeConverter(mentorVO, Mentor.class))).getId();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MentorDTO findById(@PathVariable("id") Long id) throws NotFoundException {

		return entityTypeConverter(mentorService.findById(id), MentorDTO.class);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MentorDTO> findAll(Long id) {

		return modelMapper.map(mentorService.listaMentores(), new TypeToken<List<MentorDTO>>() {
		}.getType());
	}

	@GetMapping("/nome/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public MentorDTO findByNome(@PathVariable String nome) throws NotFoundException {

		return entityTypeConverter(mentorService.findByNome(nome), MentorDTO.class);

	}

}
