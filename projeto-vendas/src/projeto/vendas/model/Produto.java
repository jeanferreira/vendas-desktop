package projeto.vendas.model;

/**
 *
 * @author jeansf
 */
public class Produto {

	private Long cod_produto;
	private String nome_produto;
	private String tipo_produto;
	private Long produto_tipo;
	private Double preco_produto;

	public Produto() {

	}

	public Produto(Long cod_produto, String tipo_produto, String nome_produto,
			Double preco_produto) {
		this.cod_produto = cod_produto;
		this.tipo_produto = tipo_produto;
		this.nome_produto = nome_produto;
		this.preco_produto = preco_produto;
	}

	public Produto(Long produto_tipo, String nome_produto, Double preco_produto) {
		this.produto_tipo = produto_tipo;
		this.nome_produto = nome_produto;
		this.preco_produto = preco_produto;
	}

	public Long getProduto_tipo() {
		return produto_tipo;
	}

	public void setProduto_tipo(Long produto_tipo) {
		this.produto_tipo = produto_tipo;
	}

	public Long getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Long cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	public Double getPreco_produto() {
		return preco_produto;
	}

	public void setPreco_produto(Double preco_produto) {
		this.preco_produto = preco_produto;
	}
}