package com.heyorange.heyorange.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HISTORICO_MENTORIA")
public class HistoricoMentoria extends AbstractEntity<Long> {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_HISTORICO", referencedColumnName = "ID")
	private Historico historico;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MENTORIA", referencedColumnName = "ID")
	private Mentoria mentoria;

}
