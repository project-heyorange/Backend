package com.heyorange.heyorange.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum StatusAgendamentoMentoriaEnum {

	AGENDADA(1, "AGENDADA"), //
	CONFIRMADA(2, "CONFIRMADA"), //
	CANCELADA(3, "CANCELADA");

	private static final Map<String, StatusAgendamentoMentoriaEnum> LOOKUP = new HashMap<>();

	static {
		for (StatusAgendamentoMentoriaEnum e : StatusAgendamentoMentoriaEnum.values()) {
			LOOKUP.put(e.getStatus(), e);
		}
	}

	public static StatusAgendamentoMentoriaEnum valueOfDescription(String status) {

		return status != null ? LOOKUP.get(status) : null;
	}

	private final int id;

	private final String status;

	StatusAgendamentoMentoriaEnum(int id, String status) {
		this.id = id;
		this.status = status;
	}

}
