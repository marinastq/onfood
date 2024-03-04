package br.com.marinastq.produto;

import java.math.BigDecimal;
import java.util.List;

import br.com.marinastq.pedido.ItemPedido;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Produto extends PanacheEntity{

	public String nome;
	public String descricao;
	public BigDecimal preco;
	public Boolean ativo;
	
	@OneToMany(mappedBy = "produto")
	public List<FotoProduto> fotosProduto;
	
	@OneToMany(mappedBy = "produto")
	public List<ItemPedido> itensPedido;
	
}
