package com.heyorange.heyorange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.entity.Usuario;
import com.heyorange.heyorange.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Long create(final Usuario usuario) {

		return saveAndFlush(usuario).getId();

	}

	public Usuario findById(final Long id) {

		return usuarioRepository.findById(id).orElseThrow();
	}

	public List<Usuario> listaUsuarios() {

		return usuarioRepository.findAll();
	}

	private Usuario saveAndFlush(final Usuario usuario) {

		return usuarioRepository.saveAndFlush(usuario);
	}

}
