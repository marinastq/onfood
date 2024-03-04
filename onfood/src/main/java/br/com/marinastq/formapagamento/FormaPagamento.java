package br.com.marinastq.formapagamento;

import java.util.List;

import br.com.marinastq.pedido.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class FormaPagamento extends PanacheEntity {
	public String descricao;
	
	@OneToMany(mappedBy = "formaPagamento")
	public List<Pedido> pedidos;

}
