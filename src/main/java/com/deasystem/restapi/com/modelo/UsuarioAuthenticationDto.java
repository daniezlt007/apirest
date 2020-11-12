package com.deasystem.restapi.com.modelo;

public class UsuarioAuthenticationDto {
	
	private String tipo;
	private String email;
	private String nome;
	private String token;
	
	public UsuarioAuthenticationDto() {
		super();
	}

	public UsuarioAuthenticationDto(String tipo, String email, String nome, String token) {
		super();
		this.tipo = tipo;
		this.email = email;
		this.nome = nome;
		this.token = token;
	}
	
	public static UsuarioAuthenticationDto toDto(Usuario usuario, String tipo) {
		return new UsuarioAuthenticationDto(tipo, usuario.getEmail(), usuario.getNome(), usuario.getToken());
	}

	public String getTipo() {
		return tipo;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getToken() {
		return token;
	}

	
}
