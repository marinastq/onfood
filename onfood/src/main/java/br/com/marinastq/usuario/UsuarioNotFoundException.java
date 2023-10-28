package br.com.marinastq.usuario;

import java.io.Serializable;

public class UsuarioNotFoundException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(long id) {
		super("User id = " + id + " not found.");
	}
}
