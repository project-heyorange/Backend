package com.heyorange.heyorange.exception;

public class ServerException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServerException() {
		super("Sem conexão com a internet. Impossivel enviar e-mail");
	}

}
