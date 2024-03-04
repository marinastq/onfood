package br.com.marinastq.usuario;

import java.time.LocalDate;
import java.util.List;

import br.com.marinastq.grupo.Grupo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String nome;
	public String email;
	public String senha;
	public LocalDate dataCadastro;
	
	@ManyToOne
	private List<Grupo> grupos;
	
}
