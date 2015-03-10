package projeto.vendas.view;

import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import projeto.vendas.dao.ProductDAO;
import projeto.vendas.model.Produto;
import projeto.vendas.model.TipoProduto;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JFProduto extends JFrame {

	/**
	 * 
	 */
	private static JFProduto INSTANCIA_PRODUTO;
	
	private final ProductDAO pDAO;
	private Produto pr;
	private List<Produto> lsProduto;
	DefaultTableModel tmProduto = new DefaultTableModel(null, new String[] {
			"COD", "TIPO", "NOME", "PREÇO" }) {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	private static final long serialVersionUID = 1266238301581591536L;
	private JPanel jPContentProduct;
	private JTextField jTPesquisar;
	private JButton jBPesquisar;
	private JPanel jPBotoes;
	private JButton jBNovo;
	private JButton jBSalvar;
	private JButton jBLimpar;
	private JPanel jPDados;
	private JLabel jLCod;
	private JTextField jTCod;
	private JLabel jLNome;
	private JTextField jTNome;
	private JLabel jLTipo;
	private JComboBox jCBTipo;
	private JLabel jLPreco;
	private JFormattedTextField jTPreco;
	private JPanel jPResultado;
	private JTable jTableProduto;
	private JScrollPane jScrollPaneListarProduto;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	
	public static synchronized JFProduto getInstance() throws SQLException {
		if (INSTANCIA_PRODUTO == null) {
			INSTANCIA_PRODUTO = new JFProduto();
		}
		return INSTANCIA_PRODUTO;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFProduto frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public JFProduto() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFProduto.class.getResource("/projeto/vendas/images/cer_btn12.png")));
		initComponents();
		desabilitaDados();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.pDAO = new ProductDAO();
		carregaJCTipoProduto();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 542);
		jPContentProduct = new JPanel();
		jPContentProduct.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPContentProduct);
		jPContentProduct.setLayout(null);

		jTPesquisar = new JTextField();
		jTPesquisar.setBounds(10, 11, 535, 20);
		jPContentProduct.add(jTPesquisar);
		jTPesquisar.setColumns(10);

		jBPesquisar = new JButton("Pesquisar");
		jBPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisarProduto();
					jTPesquisar.setText("");
				} catch (SQLException ex) {
					Logger.getLogger(JFProduto.class.getName()).log(
							Level.SEVERE, null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBPesquisar.setIcon(new ImageIcon(JFProduto.class
				.getResource("/projeto/vendas/images/1999_16x16.png")));
		jBPesquisar.setBounds(555, 10, 99, 23);
		jPContentProduct.add(jBPesquisar);

		jPBotoes = new JPanel();
		jPBotoes.setBorder(new TitledBorder(null, "Bot\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPBotoes.setBounds(10, 42, 644, 92);
		jPContentProduct.add(jPBotoes);
		jPBotoes.setLayout(null);

		jBNovo = new JButton("Novo");
		jBNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				habilitaDados();

			}
		});
		jBNovo.setIcon(new ImageIcon(JFProduto.class
				.getResource("/projeto/vendas/images/novo.png")));
		jBNovo.setBounds(21, 24, 106, 40);
		jPBotoes.add(jBNovo);

		jBSalvar = new JButton("Salvar");
		jBSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (verificaDados()) {
						cadastraProduto();
						limparDados();
						desabilitaDados();
					}

				} catch (SQLException ex) {
					Logger.getLogger(JFProduto.class.getName()).log(
							Level.SEVERE, null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBSalvar.setIcon(new ImageIcon(JFProduto.class
				.getResource("/projeto/vendas/images/1428_32x32.png")));
		jBSalvar.setBounds(137, 25, 106, 40);
		jPBotoes.add(jBSalvar);

		jBLimpar = new JButton("Limpar");
		jBLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparDados();
			}
		});
		jBLimpar.setIcon(new ImageIcon(JFProduto.class
				.getResource("/projeto/vendas/images/Eraser-32.png")));
		jBLimpar.setBounds(528, 24, 106, 40);
		jPBotoes.add(jBLimpar);

		jPDados = new JPanel();
		jPDados.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		jPDados.setBounds(10, 145, 644, 92);
		jPContentProduct.add(jPDados);
		jPDados.setLayout(null);

		jLCod = new JLabel("Cod:");
		jLCod.setBounds(10, 21, 46, 14);
		jPDados.add(jLCod);

		jTCod = new JTextField();
		jTCod.setBounds(66, 18, 127, 20);
		jPDados.add(jTCod);
		jTCod.setColumns(10);

		jLNome = new JLabel("Nome:");
		jLNome.setBounds(232, 21, 46, 14);
		jPDados.add(jLNome);

		jTNome = new JTextField();
		jTNome.setBounds(288, 18, 346, 20);
		jPDados.add(jTNome);
		jTNome.setColumns(10);

		jLTipo = new JLabel("Tipo:");
		jLTipo.setBounds(10, 56, 46, 14);
		jPDados.add(jLTipo);

		jCBTipo = new JComboBox();
		jCBTipo.setBounds(66, 53, 127, 20);
		jPDados.add(jCBTipo);

		jLPreco = new JLabel("Pre\u00E7o:");
		jLPreco.setBounds(232, 56, 46, 14);
		jPDados.add(jLPreco);

		jTPreco = new JFormattedTextField();
		jTPreco.setBounds(288, 53, 127, 20);
		jTPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(
						new java.text.DecimalFormat("¤#,##0.00"))));
		jTPreco.setText("R$");
		jPDados.add(jTPreco);

		jPResultado = new JPanel();
		jPResultado.setBounds(10, 248, 644, 244);
		jPContentProduct.add(jPResultado);
		jPResultado.setLayout(null);

		jScrollPaneListarProduto = new JScrollPane();
		jScrollPaneListarProduto.setBounds(10, 11, 624, 222);
		jPResultado.add(jScrollPaneListarProduto);

		jTableProduto = new JTable();
		jTableProduto.setModel(tmProduto);
		jScrollPaneListarProduto.setViewportView(jTableProduto);

	}

	public final void desabilitaDados() {
		jTCod.setEditable(false);
		jCBTipo.setEditable(false);
		jTNome.setEditable(false);
		jTPreco.setEditable(false);
	}

	public void habilitaDados() {
		jTCod.setEditable(false);
		jTNome.setEditable(true);
		jCBTipo.setEditable(true);
		jTPreco.setEditable(true);
	}

	public void limparDados() {
		jTCod.setText("");
		jCBTipo.setSelectedItem(null);
		jTNome.setText("");
		jTPreco.setText("R$");
	}

	public boolean verificaDados() {
		if (jTNome.getText().equals("")
				|| jCBTipo.getSelectedItem().toString().equals("")
				|| jTPreco.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campos não podem ser vazios");
			return false;
		} else {
			return true;
		}
	}

	public void carregaJCTipoProduto() throws SQLException {
		List<TipoProduto> l = pDAO.listarTipos();

		jCBTipo.setSelectedItem("");
		for (TipoProduto l1 : l) {
			jCBTipo.addItem(l1.getId_produto() + "-" + l1.getTipo_produto());
		}
	}

	public void cadastraProduto() throws SQLException {
		pr = new Produto(Long.parseLong(jCBTipo.getSelectedItem().toString()
				.replaceAll("[^0-9]", "")), jTNome.getText().toUpperCase(),
				Double.parseDouble(jTPreco.getText().replace("R$", "")
						.replace(",", ".")));
		pDAO.cadastrarProduto(pr);
		JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso");
	}

	public void pesquisarProduto() throws SQLException {
		lsProduto = pDAO.listarProdutos("%" + jTPesquisar.getText().toUpperCase() + "%");
		mostrarProduto(lsProduto);
	}

	private void mostrarProduto(List<Produto> lsprodutos) {

		while (tmProduto.getRowCount() > 0) {
			tmProduto.removeRow(0);
		}

		if (lsProduto.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum produto encontrado");
		} else {
			String[] linha = new String[] { null, null, null, null };
			tmProduto.addRow(linha);
			for (int i = 0; i < lsprodutos.size(); i++) {
				tmProduto.addRow(linha);
				tmProduto.setValueAt(lsprodutos.get(i).getCod_produto(), i, 0);
				tmProduto.setValueAt(lsprodutos.get(i).getTipo_produto(), i, 1);
				tmProduto.setValueAt(lsprodutos.get(i).getNome_produto(), i, 2);
				tmProduto
						.setValueAt(lsprodutos.get(i).getPreco_produto(), i, 3);
			}
		}
	}
}
