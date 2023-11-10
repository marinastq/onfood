package br.com.marinastq.permissao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PermissaoRepository implements PanacheRepository<Permissao>{

	public Permissao findByNome(String nome){
		return find("nome", nome).firstResult();
	}

}
