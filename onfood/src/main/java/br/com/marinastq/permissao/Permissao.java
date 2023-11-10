package br.com.marinastq.permissao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Permissao extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String nome;
	public String descricao;
	
}
