package br.com.marinastq.usuario;

import java.time.LocalDate;

import br.com.marinastq.grupo.Grupo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String nome;
	public String email;
	public String senha;
	public LocalDate dataCadastro;
	
	
	@ManyToOne(targetEntity = Grupo.class)
	@JoinColumn(name = "grupoId")
	public Grupo grupo;
	
	
}
