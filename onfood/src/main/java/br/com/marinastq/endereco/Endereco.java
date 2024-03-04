package br.com.marinastq.endereco;

import java.util.List;

import br.com.marinastq.pedido.Pedido;
import br.com.marinastq.restaurante.Restaurante;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
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
	
	@ManyToOne(targetEntity=Cidade.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade_id", referencedColumnName = "id")
	public Cidade cidade;
	
	@OneToMany(mappedBy = "pedido")
	public List<Pedido> pedido;
	
	@OneToOne(mappedBy = "endereco")
	public Restaurante restaurante;
	
}
