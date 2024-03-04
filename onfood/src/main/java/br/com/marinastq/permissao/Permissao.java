package br.com.marinastq.permissao;

import br.com.marinastq.grupo.Grupo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Permissao extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String nome;
	public String descricao;
	
	@ManyToOne
	public Grupo grupo;
	
}
