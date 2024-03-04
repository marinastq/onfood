package br.com.marinastq.produto;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class FotoProduto extends PanacheEntity{

	public String nomeArquivo;
	public String descricao;
	public String content;
	public Long tamanho;
	
	@ManyToOne
	public Produto produto;
}
