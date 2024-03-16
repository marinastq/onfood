package br.com.marinastq.restaurante;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.marinastq.endereco.Endereco;
import br.com.marinastq.formapagamento.FormaPagamento;
import br.com.marinastq.pedido.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Restaurante extends PanacheEntity{

	public String nome;
	public BigDecimal taxaFrete;
	public Boolean ativo;
	public Boolean aberto;
	public LocalDateTime dataCadastro;
	public LocalDateTime dataAtualizacao;
	
	@OneToMany(mappedBy = "restaurante")
	public List<Pedido> pedido;
	
	@OneToOne
	public Endereco endereco;
	
	@ManyToOne
	public FormaPagamento formaPagamento;
}
