package projeto.vendas.model;

/**
 *
 * @author jeansf
 */
public class Cidade {

	private Integer id;
	private String nome_cidade;
	private String ibge;
	private Integer estado_id;

	public Cidade() {

	}

	public Cidade(Integer id, String nome_cidade, String ibge, Integer estado_id) {
		this.id = id;
		this.nome_cidade = nome_cidade;
		this.ibge = ibge;
		this.estado_id = estado_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public Integer getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}

}
