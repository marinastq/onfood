package br.com.marinastq.endereco;

import java.util.List;

import br.com.marinastq.pedido.Pedido;
import br.com.marinastq.restaurante.Restaurante;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Endereco  extends PanacheEntity{
	//panache gerencia ID no PanacheEntity
	public String cep;
	public String logradouro;
	public String numero;
	public String complemento;
	public String bairro;
	
	@ManyToOne//(targetEntity=Cidade.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Cidade cidade;
	
	@OneToMany(mappedBy = "endereco")
	public List<Pedido> pedido;
	
	@OneToOne(mappedBy = "endereco")
	public Restaurante restaurante;
	
}
