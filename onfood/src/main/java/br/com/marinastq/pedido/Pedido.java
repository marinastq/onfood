package br.com.marinastq.pedido;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.marinastq.endereco.Endereco;
import br.com.marinastq.formapagamento.FormaPagamento;
import br.com.marinastq.restaurante.Restaurante;
import br.com.marinastq.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido extends PanacheEntity{
	public BigDecimal subtotal;
	public BigDecimal taxaFrete;
	public BigDecimal valorTotal;
	public Calendar dataCriacao;
	public Calendar dataConfirmacao;
	public Calendar dataCancelamento;
	public Calendar dataEntrega;
	
	public StatusPedido statusPedido;
	
	@ManyToOne
	public Endereco endereco;
	
	public Usuario usuario;
	
	@OneToMany(mappedBy = "pedido")
	public List<ItemPedido> listaItemPedidos;
	
	@ManyToOne
	public Restaurante restaurante;
	
	@ManyToOne
	public FormaPagamento formaPagamento;
	
	
	
}
