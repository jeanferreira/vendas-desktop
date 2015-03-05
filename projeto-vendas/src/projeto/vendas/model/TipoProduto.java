package projeto.vendas.model;

/**
 *
 * @author jeansf
 */
public class TipoProduto {

	private Long id_produto;
	private String tipo_produto;

	public TipoProduto() {

	}

	public TipoProduto(Long id_produto, String tipo_produto) {
		this.id_produto = id_produto;
		this.tipo_produto = tipo_produto;
	}

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public String getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

}
