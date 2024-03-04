package br.com.marinastq.pedido;

import java.math.BigDecimal;

import br.com.marinastq.produto.Produto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido  extends PanacheEntity{
	public Integer quantidade;
	public BigDecimal precoUnitario;
	public BigDecimal precoTotal;
	public String observacao;
	
	@ManyToOne
	public Pedido pedido;
	
	@ManyToOne
	public Produto produto;
}
