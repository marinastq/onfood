package br.com.marinastq.usuario;

public class UsuarioNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(long id) {
		super("User id = " + id + " not found.");
	}
}
