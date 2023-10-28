package br.com.marinastq.usuario;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {
	
	@Inject
	UsuarioRepository usuarioRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(){
//		return Usuario.listAll();
		List<Usuario> lista = Usuario.listAll();
		
		return Response.ok(lista).status(201).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findById")
	public Response findUserById(@QueryParam("id") long id) {
		Usuario usuario = Usuario.findById(id);

		if(usuario == null) {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		
		return Response.ok(usuario).status(201).build();
	}
	
	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response newUsuario(Usuario usuario) {
		if(usuarioRepository.findByNome(usuario.getNome()) == null) {
			usuario.id = null;
			usuario.dataCadastro = LocalDate.now();
			usuario.persist();
		}
		
//		return Response.status(Status.CREATED).entity(usuario).build();
		return Response.created(URI.create("/usuarios/" + usuario.id)).build();
	}
	
	@Transactional
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUsuario(@PathParam("id") Long id, Usuario usuario) {
		Usuario usuarioNew = usuarioRepository.findById(id);
	    if(usuarioNew == null) {
	    	throw new UsuarioNotFoundException(id);
	    }

	    // map all fields from the person parameter to the existing entity
	    usuarioNew.id = usuario.id;
	    usuarioNew.nome = usuario.nome;
	    usuarioNew.email = usuario.email;
	    usuarioNew.senha = usuario.senha;
	    usuarioNew.dataCadastro = LocalDate.now();

	    usuarioNew.persist();
	    return Response.created(URI.create("/usuarios/" + usuario.id)).build();	
	}
	
	@Transactional
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
		Usuario usuario = usuarioRepository.findById(id);
		
		if(usuario == null) {
			throw new UsuarioNotFoundException(id);
		}
		
		usuario.delete();
		return Response.noContent().status(201).build();
    }
}
