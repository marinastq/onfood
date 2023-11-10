package br.com.marinastq.grupo;

import java.io.Serializable;

public class GrupoNotFoundException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;

	public GrupoNotFoundException(long id) {
		super("Grupo id = " + id + " not found.");
	}
}
