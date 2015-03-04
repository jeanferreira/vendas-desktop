package projeto.vendas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.vendas.model.Cidade;
import projeto.vendas.model.Customer;
import projeto.vendas.model.Estado;
import projeto.vendas.persistence.ConexaoBD;

/**
 *
 * @author jeansf
 */
public class CustomerDAO {

	private final Connection conexao;
	private Customer c;
	private Estado es;
	private Cidade cidade;
	private static final String LISTA_ESTADOS = "SELECT es.sigla FROM estados es ORDER BY es.nome ASC";
	private static final String LISTA_CIDADES = "SELECT c.nome FROM estados es, cidades c WHERE  es.sigla = ? and es.id_estado = c.estado_id ORDER BY c.nome";
	private static final String CADASTRAR_CLIENTE = "INSERT INTO cliente(cpf_cliente,estado_civil_cliente,sexo_cliente,nome_cliente,rg_cliente,data_nasc_cliente,endereco_cliente,cep_cliente,nome_mae_cliente,nome_pai_cliente,telefone_cliente,estado_cliente,cidade_cliente,email_cliente,bairro_cliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String LISTAR_CLIENTE = "SELECT * FROM cliente c WHERE c.nome_cliente LIKE ?";

	public CustomerDAO() throws SQLException {
		this.conexao = ConexaoBD.getConexao();
	}

	public List<Estado> listaEstados() throws SQLException {

		PreparedStatement stmt = this.conexao.prepareStatement(LISTA_ESTADOS);
		ResultSet rs = stmt.executeQuery();
		List<Estado> list = new ArrayList<>();

		while (rs.next()) {
			es = new Estado();
			es.setNome_estado(rs.getString("sigla"));
			list.add(es);
		}

		stmt.close();
		rs.close();

		return list;

	}

	public List<Cidade> listaCidades(String estado) throws SQLException {

		PreparedStatement stmt = this.conexao.prepareStatement(LISTA_CIDADES);
		stmt.setString(1, estado);
		ResultSet rs = stmt.executeQuery();

		List<Cidade> list = new ArrayList<>();

		while (rs.next()) {
			cidade = new Cidade();
			cidade.setNome_cidade(rs.getString("nome"));
			list.add(cidade);
		}

		stmt.close();
		rs.close();

		return list;

	}

	public void cadastrarCliente(Customer ct) throws SQLException {

		PreparedStatement stmt = this.conexao
				.prepareStatement(CADASTRAR_CLIENTE);

		stmt.setLong(1, ct.getCpf());
		stmt.setString(2, ct.getEstado_civil());
		stmt.setString(3, ct.getSexo());
		stmt.setString(4, ct.getNome_cliente());
		stmt.setString(5, ct.getRg());
		stmt.setDate(6, (Date) ct.getDataNasc());
		stmt.setString(7, ct.getEndereco());
		stmt.setLong(8, ct.getCep());
		stmt.setString(9, ct.getNome_mae());
		stmt.setString(10, ct.getNome_pai());
		stmt.setLong(11, ct.getTelefone());
		stmt.setString(12, ct.getEstado());
		stmt.setString(13, ct.getCidade());
		stmt.setString(14, ct.getEmail());
		stmt.setString(15, ct.getBairro());

		stmt.execute();
		stmt.close();
	}

	public List<Customer> listarCliente(String nome) throws SQLException {

		PreparedStatement stmt = this.conexao.prepareStatement(LISTAR_CLIENTE);
		stmt.setString(1, nome);

		ResultSet rs = stmt.executeQuery();
		List<Customer> minhaLista = new ArrayList<>();

		while (rs.next()) {
			c = new Customer(rs.getLong("cpf_cliente"),
					rs.getString("estado_civil_cliente"),
					rs.getString("sexo_cliente"), rs.getString("nome_cliente"),
					rs.getString("rg_cliente"),
					rs.getDate("data_nasc_cliente"),
					rs.getString("endereco_cliente"),
					rs.getLong("cep_cliente"),
					rs.getString("nome_mae_cliente"),
					rs.getString("nome_pai_cliente"),
					rs.getLong("telefone_cliente"),
					rs.getString("estado_cliente"),
					rs.getString("cidade_cliente"),
					rs.getString("email_cliente"),
					rs.getString("bairro_cliente"));
			minhaLista.add(c);
		}

		stmt.close();
		rs.close();

		return minhaLista;

	}
}