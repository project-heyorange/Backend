package com.heyorange.heyorange.domain.entity;

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
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "DOMINIO_HABILIDADES")
public class DominioHabilidades extends AbstractDominio<Long> {

}
