package br.com.marinastq.usuario;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	/*
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
			//retorna sucesso sem conteudo 204
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		
		return Response.ok(usuario).status(201).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findByNome")
	public Response findUserByNome(@QueryParam("nome") String nome) {
		Usuario usuario = usuarioRepository.findByNome(nome);

		if(usuario == null) {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		
		return Response.ok(usuario).status(201).build();
	}
	
	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response newUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioDTOtoEntity(usuarioDTO);
		
		if(usuarioRepository.findByNome(usuario.nome) == null) {
			usuario.id = null;
//			usuario.dataCadastro = LocalDateTime.now();
			usuario.persist();
		}
		
//		return Response.status(Status.CREATED).entity(usuario).build();
		return Response.created(URI.create("/usuarios/" + usuario.id)).build();
	}

	private Usuario usuarioDTOtoEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.nome = usuarioDTO.nome();
		usuario.email = usuarioDTO.email();
		usuario.senha = usuarioDTO.senha();
		return usuario;
	}
	
	private UsuarioDTO usuarioEntityToDTO(Usuario usuario) {
		return new UsuarioDTO(
				usuario.nome,
				usuario.email,
				usuario.senha);
	}
	
	@Transactional
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUsuario(@PathParam("id") Long id, UsuarioDTOUpdate usuarioUpdateDTO) throws UsuarioNotFoundException{
		Usuario usuario = usuarioRepository.findById(id);
	    if(usuario == null) {
			//retorna sucesso sem conteudo 204
			//return Response.status(Response.Status.NO_CONTENT).build();
			//lanca Exception no console
	    	throw new UsuarioNotFoundException(id);
	    }

	    // map all fields from the person parameter to the existing entity
	    usuario.nome = usuarioUpdateDTO.nome();
	    usuario.email = usuarioUpdateDTO.email();
	    usuario.senha = usuarioUpdateDTO.senha();

	    return Response.created(URI.create("/usuarios/" + usuario.id)).build();
	}
	
	@Transactional
    @DELETE
    @Path("/{id}")
	@Produces(MediaType.TEXT_XML)
    public Response delete(@PathParam("id") Long id) throws UsuarioNotFoundException {
		Usuario usuario = usuarioRepository.findById(id);
		
		if(usuario == null) {
			throw new UsuarioNotFoundException(id);
		}
		
		usuario.delete();
		return Response.noContent().status(201).build();
    }
    */
}
