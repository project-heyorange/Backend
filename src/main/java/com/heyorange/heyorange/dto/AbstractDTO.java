package com.heyorange.heyorange.dto;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class AbstractDTO <I extends Serializable> {
	
}
