package br.com.marinastq.usuario;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UsuarioNotFoundMapperException implements ExceptionMapper<UsuarioNotFoundException> {
	@Override
	public Response toResponse(UsuarioNotFoundException exception) 
	{
		return Response.status(Status.OK).entity(exception.getMessage()).build();  
	}
}
