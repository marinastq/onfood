package br.com.marinastq.grupo;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GrupoNotFoundMapperException implements ExceptionMapper<GrupoNotFoundException> {
	@Override
	public Response toResponse(GrupoNotFoundException exception) 
	{
		return Response.status(Status.OK).entity(exception.getMessage()).build();  
	}
}
