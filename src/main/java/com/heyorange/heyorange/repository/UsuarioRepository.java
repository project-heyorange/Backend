package com.heyorange.heyorange.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public static List<Usuario> findAllByNomeContainingIgnoreCase(String nome){
		return null;
	}
	
}