package br.com.marinastq.usuario;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Usuario extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String nome;
	public String email;
	public String senha;
	public LocalDate dataCadastro;
	
}
