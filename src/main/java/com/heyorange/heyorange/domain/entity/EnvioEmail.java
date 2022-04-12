package com.heyorange.heyorange.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import com.heyorange.heyorange.constants.DatabaseConstants;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "ENVIO_EMAIL")
public class EnvioEmail extends AbstractEntity<Long> {

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "ASSUNTO")
	private String assunto;

	@Column(name = "CONTEUDO")
	private String conteudo;

	@Column(name = "NUMERO_TENTATIVAS")
	private int numeroTentativas;

	@Column(name = "ID_DOMINIO_TIPO_EMAIL")
	private int idDominioTipoEmail;

}
