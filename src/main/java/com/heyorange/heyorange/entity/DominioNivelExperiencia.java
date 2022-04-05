package com.heyorange.heyorange.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.heyorange.heyorange.constants.DatabaseConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(schema = DatabaseConstants.HEY_ORANGE, name = "DOMIBIO_NIVEL_EXPERIENCIA")
public class DominioNivelExperiencia extends AbstractDominio <Long> {
	
}