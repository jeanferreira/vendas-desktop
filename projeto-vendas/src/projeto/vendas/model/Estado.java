package projeto.vendas.model;

/**
 *
 * @author jeansf
 */
public class Estado {

	private String nome_estado;
	private String sigla;

	public Estado() {

	}

	public Estado(String nome_estado, String sigla) {
		this.nome_estado = nome_estado;
		this.sigla = sigla;
	}

	public String getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
