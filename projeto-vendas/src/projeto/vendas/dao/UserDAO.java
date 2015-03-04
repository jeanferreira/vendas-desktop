package projeto.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.vendas.model.User;
import projeto.vendas.persistence.ConexaoBD;


/**
 *
 * @author jeansf
 */
public class UserDAO {

	private final Connection conexao;
	private User us;
	private static final String CONNECT = "SELECT *FROM usuario us WHERE us.usuario = ? AND us.senha = ?";
	private boolean AUTENTICADO = false;

	public UserDAO() throws SQLException {
		this.conexao = ConexaoBD.getConexao();
		this.us = new User();
	}

	public boolean connect(String usuario, String senha) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement(CONNECT);

		stmt.setString(1, usuario);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			us.setUsuario(rs.getString("usuario"));
			us.setSenha(rs.getString("senha"));
			AUTENTICADO = true;
		}

		return AUTENTICADO;

	}
}
