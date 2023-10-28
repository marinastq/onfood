package br.com.marinastq.usuario;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
	
	
	public Usuario findByNome(String nome){
		return find("nome", nome).firstResult();
	}
	

}
