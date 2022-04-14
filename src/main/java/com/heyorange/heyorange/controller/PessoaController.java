package com.heyorange.heyorange.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heyorange.heyorange.domain.dto.IdDTO;
import com.heyorange.heyorange.domain.dto.PessoaDTO;
import com.heyorange.heyorange.domain.entity.Pessoa;
import com.heyorange.heyorange.domain.vo.PessoaVO;
import com.heyorange.heyorange.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController extends BaseController {

	@Autowired
	private PessoaService pessoaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody @Valid final PessoaVO pessoaVO) {

		return new IdDTO(pessoaService.create(entityTypeConverter(pessoaVO, Pessoa.class))).getId();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PessoaDTO findById(@PathVariable("id")Long id) {

		return entityTypeConverter(pessoaService.findById(id), PessoaDTO.class);
	}

	@GetMapping("/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public PessoaDTO findByNome(@PathVariable("nome") String nome) {

		return entityTypeConverter(pessoaService.findByNome(nome), PessoaDTO.class);

	}

}
