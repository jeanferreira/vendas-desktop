package projeto.vendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.vendas.model.Produto;
import projeto.vendas.model.TipoProduto;
import projeto.vendas.persistence.ConexaoBD;


/**
 *
 * @author jeansf
 */
public class ProductDAO {
    
    private final Connection conexao;
    private TipoProduto tp;
    private Produto prod;
    private List<TipoProduto> lsTP;
    private List<Produto> lsProd;
    private static final String LISTAR_TIPOS = "SELECT tp.id_tipo, tp.tipo_produto FROM tipo_produto tp";
    private static final String CADASTRAR_PRODUTO = "INSERT INTO produto(cod_produto,produto_tipo,nome_produto,preco_produto) VALUES(nextval('produto_sq'),?,?,?)";
    private static final String LISTAR_PRODUTO = "SELECT *FROM produtos_vw p WHERE p.nome_produto LIKE ?";
    
    public ProductDAO() throws SQLException {
        this.conexao = ConexaoBD.getConexao();
    }
    
    public List<TipoProduto> listarTipos() throws SQLException {
        
        PreparedStatement stmt = this.conexao.prepareStatement(LISTAR_TIPOS);
        ResultSet rs = stmt.executeQuery();
        lsTP = new ArrayList<>();
        
        while (rs.next()) {            
            tp = new TipoProduto();
            tp.setId_produto(Long.parseLong(rs.getString("id_tipo")));
            tp.setTipo_produto(rs.getString("tipo_produto"));
            lsTP.add(tp);
        }
        
        stmt.close();
        rs.close();
        
        return lsTP;
    }
    
    public List<Produto> listarProdutos(String prodNome) throws SQLException {
        
        PreparedStatement stmt = this.conexao.prepareStatement(LISTAR_PRODUTO);
        stmt.setString(1, prodNome);
        ResultSet rs = stmt.executeQuery();
        
        lsProd = new ArrayList<>();
        
        while (rs.next()) {            
            prod = new Produto(rs.getLong("cod_produto"),rs.getString("tipo_produto"),rs.getString("nome_produto"),rs.getDouble("preco_produto"));
            lsProd.add(prod);
        }
        return lsProd;
    }
    
    public void cadastrarProduto(Produto prod) throws SQLException {
        
        PreparedStatement stmt = conexao.prepareCall(CADASTRAR_PRODUTO);
        
        stmt.setLong(1, prod.getProduto_tipo());
        stmt.setString(2, prod.getNome_produto());
        stmt.setDouble(3, prod.getPreco_produto());
        stmt.execute();
        stmt.close();
    }
}
