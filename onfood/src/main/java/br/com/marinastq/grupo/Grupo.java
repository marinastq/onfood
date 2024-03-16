package br.com.marinastq.grupo;

import java.util.List;

import br.com.marinastq.permissao.Permissao;
import br.com.marinastq.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Grupo extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String nome;
	
	@OneToMany(targetEntity=Permissao.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "grupo")
//	@JoinColumn(name = "grupo_id", referencedColumnName = "id")
	public List<Permissao> permissoes;
	
	
	@OneToMany(mappedBy="grupo")
//	Esses comandos são para ManyToMany
//	@JoinTable(name="usuario_grupo",
//	             joinColumns={@JoinColumn(name="usuario_id")},
//	             inverseJoinColumns={@JoinColumn(name="grupo_id")})
	private List<Usuario> usuarios;
	
	
	public Grupo(Long id, String nome, List<Permissao> permissoes) {
		this.id = id;
		this.nome = nome;
		this.permissoes = permissoes;
	}
	
	public Grupo() {
		
	}
}
