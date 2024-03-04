package br.com.marinastq.endereco;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Estado extends PanacheEntity{
	
	public String nome;
	
	@OneToMany(mappedBy = "estado")
    public List<Cidade> cidades;
}
