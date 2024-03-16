package br.com.marinastq.endereco;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cidade extends PanacheEntity{
	public String nome;

//	@OneToMany(targetEntity=Estado.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "permissao")
//	@JoinColumn(name = "estadoId", referencedColumnName = "id")
	@ManyToOne
	public Estado estado;
	
	@OneToMany(mappedBy="cidade")
	public List<Endereco> enderecos;
	
}
