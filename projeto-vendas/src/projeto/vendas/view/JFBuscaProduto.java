package projeto.vendas.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import projeto.vendas.dao.ProductDAO;
import projeto.vendas.model.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFBuscaProduto extends JFrame {
	
	DefaultTableModel tmProduto = new DefaultTableModel(null, new String[] {
			"COD", "TIPO", "NOME", "PREÇO" }) {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};

	private static JFBuscaProduto INSTANCIA_BUSCA_PRODUTO;

	private List<Produto> lsProduto;
	private final ProductDAO pDAO;

	private JPanel contentPane;
	private JTextField jTPesquisar;
	private JButton jBPesquisar;
	private JScrollPane jScrollPaneProduto;
	private JTable jTableBuscaProduto;

	public JFBuscaProduto() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFBuscaProduto.class
						.getResource("/projeto/vendas/images/cer_btn12.png")));
		initComponents();
		this.pDAO = new ProductDAO();
	}

	public static synchronized JFBuscaProduto getInstance() throws SQLException {
		if (INSTANCIA_BUSCA_PRODUTO == null) {
			INSTANCIA_BUSCA_PRODUTO = new JFBuscaProduto();
		}
		return INSTANCIA_BUSCA_PRODUTO;
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		jTPesquisar = new JTextField();
		jTPesquisar.setColumns(10);

		jBPesquisar = new JButton("Pesquisar");
		jBPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisarProduto();
				} catch (SQLException ex) {
					Logger.getLogger(JFProduto.class.getName()).log(
							Level.SEVERE, null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBPesquisar.setIcon(new ImageIcon(JFBuscaProduto.class
				.getResource("/projeto/vendas/images/1999_16x16.png")));

		jTableBuscaProduto = new JTable();
		jTableBuscaProduto.setModel(tmProduto);

		jScrollPaneProduto = new JScrollPane();
		jScrollPaneProduto.setViewportView(jTableBuscaProduto);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																jScrollPaneProduto,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																669,
																Short.MAX_VALUE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				jTPesquisar,
																				GroupLayout.DEFAULT_SIZE,
																				552,
																				Short.MAX_VALUE)
																		.addGap(18)
																		.addComponent(
																				jBPesquisar)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jTPesquisar,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBPesquisar))
										.addGap(18)
										.addComponent(jScrollPaneProduto,
												GroupLayout.DEFAULT_SIZE, 291,
												Short.MAX_VALUE)
										.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	public void pesquisarProduto() throws SQLException {
		lsProduto = pDAO.listarProdutos("%"
				+ jTPesquisar.getText().toUpperCase() + "%");
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

	public void populaProduto(JFVenda instance) {
		jTableBuscaProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Produto p = new Produto(Long.parseLong(jTableBuscaProduto.getValueAt(jTableBuscaProduto.getSelectedRow(), 0).toString()),
							jTableBuscaProduto.getValueAt(jTableBuscaProduto.getSelectedRow(), 1).toString(), 
							jTableBuscaProduto.getValueAt(jTableBuscaProduto.getSelectedRow(), 2).toString(), 
							Double.parseDouble(jTableBuscaProduto.getValueAt(jTableBuscaProduto.getSelectedRow(), 3).toString()));
					List<Produto> prod = new ArrayList<>();
					prod.add(p);
					String[] linha = new String[] { null, null, null, null };
					for (int i = 0; i < prod.size(); i++) {
						instance.getTmProduto().addRow(linha);
						instance.getTmProduto().setValueAt(prod.get(i).getCod_produto(), i, 0);
						instance.getTmProduto().setValueAt(prod.get(i).getProduto_tipo(), i, 1);
						instance.getTmProduto().setValueAt(prod.get(i).getNome_produto(), i, 2);
						instance.getTmProduto().setValueAt(prod.get(i).getPreco_produto(), i, 3);
					}
					System.out.println(p.toString());
					/*String[] linha = new String[] { null, null, null, null };
					instance.getTmProduto().addRow(linha);
					instance.getTmProduto().setValueAt(jTableBuscaProduto.getValueAt(jTableBuscaProduto.getSelectedRow(), 0).toString(), 0, 0);*/
					dispose();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFBuscaProduto frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
