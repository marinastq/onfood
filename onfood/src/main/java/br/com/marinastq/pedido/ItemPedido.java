package br.com.marinastq.pedido;

import java.math.BigDecimal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class ItemPedido  extends PanacheEntity{
	public Integer quantidade;
	public BigDecimal precoUnitario;
	public BigDecimal precoTotal;
	public String observacao;
}
