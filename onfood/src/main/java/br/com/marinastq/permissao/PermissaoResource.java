package br.com.marinastq.permissao;

import java.net.URI;
import java.util.List;

import br.com.marinastq.grupo.GrupoRepository;
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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/permissoes")
public class PermissaoResource {

	@Inject
	PermissaoRepository permissaoRepository;
	@Inject
	GrupoRepository grupoRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(){
//		return Permissao.listAll();
		List<Permissao> lista = Permissao.listAll();
		
		return Response.ok(lista).status(201).build();
	}
	
	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response newPermissao(PermissaoDTO permissaoDTO) {
		Permissao permissao = permissaoDTOtoEntity(permissaoDTO);
		
		if(permissaoRepository.findByNome(permissaoDTO.nome()) == null) {
			permissao.id = null;
			permissao.persist();
		}
		
//		return Response.status(Status.CREATED).entity(grupo).build();
		return Response.created(URI.create("/permissoes/" + permissao.id)).build();
	}
	
	private Permissao permissaoDTOtoEntity(PermissaoDTO permissaoDTO) {
		Permissao permissao = new Permissao();
		
		permissao.nome = permissaoDTO.nome();
		permissao.descricao = permissaoDTO.descricao();
		
		return permissao;
	}

	@Transactional
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePermissao(@PathParam("id") Long id, Permissao permissao) throws PermissaoNotFoundException{
		Permissao permissaoFind = permissaoRepository.findById(id);
	    if(permissaoFind == null) {
			//retorna sucesso sem conteudo 204
			//return Response.status(Response.Status.NO_CONTENT).build();
			//lanca Exception no console
	    	throw new PermissaoNotFoundException(id);
	    }
	    
	    permissaoFind.nome = permissao.nome;
	    permissaoFind.descricao = permissao.descricao;

	    return Response.created(URI.create("/permissoes/" + permissaoFind.id)).build();
	}
	
	@Transactional
    @DELETE
    @Path("/{id}")
	@Produces(MediaType.TEXT_XML)
    public Response delete(@PathParam("id") Long id) throws PermissaoNotFoundException {
		Permissao permissao = permissaoRepository.findById(id);
		
		if(permissao == null) {
			throw new PermissaoNotFoundException(id);
		}
		
		permissao.delete();
		return Response.noContent().status(201).build();
    }
}
