package projeto.vendas.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jeansf
 */
public class ConexaoBD {

    public static Connection getConexao() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Conectando ao banco");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/desktop-vendas", "postgres", "5524_je@n");

        } catch (ClassNotFoundException e) {

            throw new SQLException(e.getMessage());

        }

    }

}