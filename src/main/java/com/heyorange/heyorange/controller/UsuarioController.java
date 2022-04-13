package com.heyorange.heyorange.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heyorange.heyorange.domain.dto.IdDTO;
import com.heyorange.heyorange.domain.dto.UsuarioDTO;
import com.heyorange.heyorange.domain.entity.Usuario;
import com.heyorange.heyorange.domain.vo.UsuarioVO;
import com.heyorange.heyorange.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody @Valid final UsuarioVO usuarioVO) {

		return new IdDTO(usuarioService.create(entityTypeConverter(usuarioVO, Usuario.class))).getId();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDTO findById(Long id) {

		return entityTypeConverter(usuarioService.findById(id), UsuarioDTO.class);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> findAll(Long id) {

		return modelMapper.map(usuarioService.findById(id), new TypeToken<List<UsuarioDTO>>() {}.getType());

	}

}
