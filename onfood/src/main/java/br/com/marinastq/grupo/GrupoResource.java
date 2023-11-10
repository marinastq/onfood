package br.com.marinastq.grupo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.com.marinastq.permissao.Permissao;
import br.com.marinastq.permissao.PermissaoRepository;
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

@Path("/grupos")
public class GrupoResource {
	
	@Inject
	GrupoRepository grupoRepository;
	@Inject
	PermissaoRepository permissaoRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(){
//		return Grupo.listAll();
		List<Grupo> lista = Grupo.listAll();
		
		return Response.ok(lista).status(201).build();
	}
	
	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response newGrupo(GrupoDTO grupoDTO) {
		
		Grupo grupo = grupoDTOtoEntity(grupoDTO);
		
		if(grupoRepository.findByNome(grupoDTO.nome()) == null) {
			grupo.id = null;
			grupo.persist();
		}
		
//		return Response.status(Status.CREATED).entity(grupo).build();
		return Response.created(URI.create("/grupos/" + grupo.id)).build();
	}
	
	private Grupo grupoDTOtoEntity(GrupoDTO grupoDTO) {
		List<Permissao> listaPermissao = new ArrayList<Permissao>();
		
		Permissao permissao = permissaoRepository.findById(grupoDTO.idPermissao());
		
		if(permissao != null) {
			listaPermissao.add(permissao);
		}
		
		Grupo grupo = new Grupo(
				null, //idGrupo
				grupoDTO.nome(),
				listaPermissao
				);
		
		return grupo;
	}
	
	@Transactional
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGrupo(@PathParam("id") Long id, Grupo grupo) throws GrupoNotFoundException{
		Grupo grupoFind = grupoRepository.findById(id);
	    if(grupoFind == null) {
			//retorna sucesso sem conteudo 204
			//return Response.status(Response.Status.NO_CONTENT).build();
			//lanca Exception no console
	    	throw new GrupoNotFoundException(id);
	    }
	    
	    grupoFind.nome = grupo.nome;

	    return Response.created(URI.create("/grupos/" + grupoFind.id)).build();
	}
	
	@Transactional
    @DELETE
    @Path("/{id}")
	@Produces(MediaType.TEXT_XML)
    public Response delete(@PathParam("id") Long id) throws GrupoNotFoundException {
		Grupo grupo = grupoRepository.findById(id);
		
		if(grupo == null) {
			throw new GrupoNotFoundException(id);
		}
		
		grupo.delete();
		return Response.noContent().status(201).build();
    }
	

}
