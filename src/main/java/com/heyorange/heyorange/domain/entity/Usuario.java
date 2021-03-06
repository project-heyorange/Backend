package com.heyorange.heyorange.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.heyorange.heyorange.constants.DatabaseConstants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "USUARIO")
public class Usuario extends AbstractEntity<Long> {

	@Column(name = "NOME")
	private String nome;

	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "AREA")
	private String area;
	
	@Column(name = "NIVEL_EXPERIENCIA")
	private String nivelExperiencia;
	
	@Column(name = "EMAIL")
	private String email;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENTOR", referencedColumnName = "ID")
	private Mentor mentor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENTORADO", referencedColumnName = "ID")
	private Mentorado mentorado;

	@Column(name = "ID_DOMINIO_STATUS_USUARIO")
	private int idDominioStatusUsuario;

	@Column(name = "ID_DOMINIO_TIPO_USUARIO")
	private int idDominioTipoUsuario;

}
