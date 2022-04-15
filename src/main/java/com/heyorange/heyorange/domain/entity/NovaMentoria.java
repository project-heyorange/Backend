package com.heyorange.heyorange.domain.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "NOVA_MENTORIA")
public class NovaMentoria extends AbstractEntity<Long> {

	@Column(name = "ID_MENTORADO")
	private Long idMentorado;

	@Column(name = "ID_MENTOR")
	private Long idMentor;

	@Column(name = "DATA_MENTORIA")
	private Timestamp dataMentoria;
	
}
