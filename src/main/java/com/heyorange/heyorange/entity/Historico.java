package com.heyorange.heyorange.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.heyorange.heyorange.constants.DatabaseConstants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HISTORICO")
public class Historico extends AbstractEntity<Long> {

	@Column(name = "DATA_CRIACAO")
	private Timestamp dataCriacao;

	@Column(name = "DATA_ALTERACAO")
	private Timestamp dataAlteracao;

	@Column(name = "USUARIO_CRIACAO")
	private String usuarioCriacao;

	@Column(name = "USUARIO_ALTERACAO")
	private String usuarioAlteracao;

	@Column(name = "ID_DOMINIO_TIPO_ACAO")
	private int idDominioTipoAcao;

}
