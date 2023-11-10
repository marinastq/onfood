package br.com.marinastq.grupo;

import java.util.ArrayList;
import java.util.List;

import br.com.marinastq.permissao.Permissao;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Grupo extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String nome;
	
	@OneToMany(targetEntity=Permissao.class,cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY)
//	@JoinColumn(name = "permissaoId", referencedColumnName = "id")
	public List<Permissao> permissoes = new ArrayList<>();
	
	public Grupo(Long id, String nome, List<Permissao> permissoes) {
		this.id = id;
		this.nome = nome;
		this.permissoes = permissoes;
	}
	
	public Grupo() {
		
	}
}
