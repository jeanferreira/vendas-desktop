package projeto.vendas.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jeansf
 */
public class Customer {

	private Long cpf;
	private String estado_civil;
	private String sexo;
	private String nome_cliente;
	private String rg;
	private Date dataNasc;
	private String endereco;
	private Long cep;
	private String nome_mae;
	private String nome_pai;
	private Long telefone;
	private String estado;
	private String cidade;
	private String email;
	private String bairro;

	public Customer() {

	}

	public Customer(Long cpf, String estado_civil, String sexo,
			String nome_cliente, String rg, Date dataNasc, String endereco,
			Long cep, String nome_mae, String nome_pai, Long telefone,
			String estado, String cidade, String email, String bairro) {
		this.cpf = cpf;
		this.estado_civil = estado_civil;
		this.sexo = sexo;
		this.nome_cliente = nome_cliente;
		this.rg = rg;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.cep = cep;
		this.nome_mae = nome_mae;
		this.nome_pai = nome_pai;
		this.telefone = telefone;
		this.estado = estado;
		this.cidade = cidade;
		this.email = email;
		this.bairro = bairro;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	public String getNome_pai() {
		return nome_pai;
	}

	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String convertToString(Date d) {

		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		String data = formataData.format(d);

		return data;
	}

	public Date convertToDate(String dataNasc) throws ParseException {

		DateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = new java.sql.Date(forma.parse(dataNasc).getTime());

		return data;
	}

	@Override
	public String toString() {
		return "Customer{" + "cpf=" + cpf + ", estado_civil=" + estado_civil
				+ ", sexo=" + sexo + ", nome_cliente=" + nome_cliente + ", rg="
				+ rg + ", dataNasc=" + dataNasc + ", endereco=" + endereco
				+ ", cep=" + cep + ", nome_mae=" + nome_mae + ", nome_pai="
				+ nome_pai + ", telefone=" + telefone + ", estado=" + estado
				+ ", cidade=" + cidade + ", email=" + email + ", bairro="
				+ bairro + '}';
	}

}
