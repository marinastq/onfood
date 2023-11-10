package br.com.marinastq.permissao;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class PermissaoNotFoundMapperException implements ExceptionMapper<PermissaoNotFoundException> {
	@Override
	public Response toResponse(PermissaoNotFoundException exception) 
	{
		return Response.status(Status.OK).entity(exception.getMessage()).build();  
	}
}
