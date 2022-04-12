package com.heyorange.heyorange.domain.entity;

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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "DOMINIO_STATUS_MENTORIA")
public class DominioStatusMentoria extends AbstractDominio<Long> {

}