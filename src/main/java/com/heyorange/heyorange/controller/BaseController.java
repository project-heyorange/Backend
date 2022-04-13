
package com.heyorange.heyorange.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

	@Autowired
	protected ModelMapper modelMapper;

	protected <G, C> G entityTypeConverter(final C c, final Class<G> g) {

		return c != null ? modelMapper.map(c, g) : null;
	}

}
