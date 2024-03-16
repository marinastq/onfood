package br.com.marinastq.usuario;

import java.time.LocalDateTime;

import br.com.marinastq.grupo.Grupo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario extends PanacheEntity{
	
	//panache gerencia ID no PanacheEntity
	public String nome;
	public String email;
	public String senha;
	
//	@Column(columnDefinition = "DATETIME")
//	public LocalDateTime dataCadastro;
	
	@ManyToOne
	private Grupo grupo;
	
}
