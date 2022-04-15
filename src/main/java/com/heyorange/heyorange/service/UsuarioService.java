package com.heyorange.heyorange.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyorange.heyorange.domain.dto.UsuarioDTO;
import com.heyorange.heyorange.domain.entity.HabilidadeUsuario;
import com.heyorange.heyorange.domain.entity.Usuario;
import com.heyorange.heyorange.domain.vo.UsuarioVO;
import com.heyorange.heyorange.repository.HabilidadeUsuarioRepository;
import com.heyorange.heyorange.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private HabilidadeUsuarioRepository habilidadeUsuarioRepository;

	public Long create(final UsuarioVO usuarioVO) {

		Usuario usuario = Usuario.builder() //
				.nome(usuarioVO.getNome()) //
				.area(usuarioVO.getArea()) //
				.senha(usuarioVO.getSenha()) //
				.email(usuarioVO.getEmail()) //
				.nivelExperiencia(usuarioVO.getNivelExperiencia()) //
				.build();

		Long id = saveAndFlush(usuario).getId();
		habilidadeUsuario(usuarioVO.getHabilidade(), id);
		return id;
	}

	private void habilidadeUsuario(List<String> habilidades, Long id) {

		for (String habilidade : habilidades) {

			HabilidadeUsuario habilidadeUsuario = HabilidadeUsuario //
					.builder() //
					.nome(habilidade) //
					.idUsuario(id) //
					.build();

			habilidadeUsuarioRepository.saveAndFlush(habilidadeUsuario);
		}

	}

	public UsuarioDTO findById(final Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();

		List<HabilidadeUsuario> habilidade = habilidadeUsuarioRepository.findByidUsuario(id);
		List<String> list = new ArrayList<>();

		for (int i = 0; i < habilidade.size(); i++) {
			list.add(habilidade.get(i).getNome());
		}

		return UsuarioDTO //
				.builder() //
				.area(usuario.getArea()) //
				.email(usuario.getEmail()) //
				.nome(usuario.getNome()) //
				.nivelExperiencia(usuario.getNivelExperiencia()) //
				.id(usuario.getId()) //
				.habilidades(list) //
				.build();
	}

	public List<UsuarioDTO> listaUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuarioDTO = new ArrayList<>();

		for (Usuario usuario : usuarios) {

			List<HabilidadeUsuario> habilidade = habilidadeUsuarioRepository.findByidUsuario(usuario.getId());
			List<String> list = new ArrayList<>();

			for (int i = 0; i < habilidade.size(); i++) {
				list.add(habilidade.get(i).getNome());
			}

			usuarioDTO.add(UsuarioDTO //
					.builder() //
					.area(usuario.getArea()) //
					.email(usuario.getEmail()) //
					.nome(usuario.getNome()) //
					.nivelExperiencia(usuario.getNivelExperiencia()) //
					.id(usuario.getId()) //
					.habilidades(list) //
					.build());
		}

		return usuarioDTO;
	}

	private Usuario saveAndFlush(final Usuario usuario) {

		return usuarioRepository.saveAndFlush(usuario);
	}

}
