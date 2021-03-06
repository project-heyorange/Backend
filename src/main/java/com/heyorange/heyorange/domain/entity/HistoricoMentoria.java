package com.heyorange.heyorange.domain.entity;

import javax.persistence.CascadeType;
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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "HISTORICO_MENTORIA")
public class HistoricoMentoria extends AbstractEntity<Long> {

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_HISTORICO", referencedColumnName = "ID")
	private Historico historico;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_MENTORIA", referencedColumnName = "ID")
	private Mentoria mentoria;

}
