package com.deasystem.restapi.com.exception;

public class InvalidToken extends RuntimeException {

	public InvalidToken() {
		super("Token Inválido...");
	}

}
