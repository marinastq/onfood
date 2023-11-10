package br.com.marinastq.grupo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GrupoRepository  implements PanacheRepository<Grupo>{

	public Grupo findByNome(String nome){
		return find("nome", nome).firstResult();
	}
}
