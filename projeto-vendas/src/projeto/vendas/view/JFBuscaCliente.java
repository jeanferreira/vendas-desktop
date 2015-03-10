package projeto.vendas.view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import projeto.vendas.dao.CustomerDAO;
import projeto.vendas.model.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class JFBuscaCliente extends JFrame {

	private final CustomerDAO controlCus;
	List<Customer> lsCliente;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6003519484200486878L;
	private JPanel contentPane;
	private JButton jBPesquisar;
	private JTextField jTPesquisar;
	private JPanel jPContentBuscaCliente;
	private JTable jTableBuscaCliente;

	DefaultTableModel tmBuscaCliente = new DefaultTableModel(null,
			new String[] { "CPF", "NOME", "EMAIL", "TEL", "ENDEREÇO", "CEP",
					"BAIRRO", "ESTADO", "CIDADE" }) {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	private JScrollPane jScrollPaneCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFBuscaCliente frame = new JFBuscaCliente();
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
	public JFBuscaCliente() throws SQLException {
		initComponents();
		this.controlCus = new CustomerDAO();

	}

	private void initComponents() {

		setBounds(100, 100, 799, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		jBPesquisar = new JButton("Pesquisar");
		jBPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisarCliente();
				} catch (SQLException ex) {
					Logger.getLogger(JFProduto.class.getName()).log(
							Level.SEVERE, null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBPesquisar.setIcon(new ImageIcon(JFBuscaCliente.class
				.getResource("/projeto/vendas/images/1999_16x16.png")));

		jTPesquisar = new JTextField();
		jTPesquisar.setColumns(10);

		jPContentBuscaCliente = new JPanel();
		jPContentBuscaCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(jPContentBuscaCliente, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(jTPesquisar, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(jBPesquisar)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jBPesquisar)
						.addComponent(jTPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jPContentBuscaCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);

		jTableBuscaCliente = new JTable();
		jTableBuscaCliente.setModel(tmBuscaCliente);

		jScrollPaneCliente = new JScrollPane();
		jScrollPaneCliente.setViewportView(jTableBuscaCliente);

		GroupLayout gl_jPContentBuscaCliente = new GroupLayout(
				jPContentBuscaCliente);
		gl_jPContentBuscaCliente.setHorizontalGroup(gl_jPContentBuscaCliente
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_jPContentBuscaCliente
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPaneCliente,
										GroupLayout.DEFAULT_SIZE, 733,
										Short.MAX_VALUE).addContainerGap()));
		gl_jPContentBuscaCliente.setVerticalGroup(gl_jPContentBuscaCliente
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_jPContentBuscaCliente
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPaneCliente,
										GroupLayout.DEFAULT_SIZE, 265,
										Short.MAX_VALUE).addContainerGap()));
		jPContentBuscaCliente.setLayout(gl_jPContentBuscaCliente);
		contentPane.setLayout(gl_contentPane);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	public void pesquisarCliente() throws SQLException {
		lsCliente = controlCus.listarCliente("%"
				+ jTPesquisar.getText().toUpperCase() + "%");
		mostrarCliente(lsCliente);
	}

	public void mostrarCliente(List<Customer> clientes) {

		while (tmBuscaCliente.getRowCount() > 0) {
			tmBuscaCliente.removeRow(0);
		}

		if (clientes.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Nenhum resultado obtido");
		} else {
			String[] linha = new String[] { null, null, null, null, null, null,
					null, null, null };
			for (int i = 0; i < clientes.size(); i++) {
				tmBuscaCliente.addRow(linha);
				tmBuscaCliente.setValueAt(clientes.get(i).getCpf(), i, 0);
				tmBuscaCliente.setValueAt(clientes.get(i).getNome_cliente(), i,
						1);
				tmBuscaCliente.setValueAt(clientes.get(i).getEmail(), i, 2);
				tmBuscaCliente.setValueAt(clientes.get(i).getTelefone(), i, 3);
				tmBuscaCliente.setValueAt(clientes.get(i).getEndereco(), i, 4);
				tmBuscaCliente.setValueAt(clientes.get(i).getCep(), i, 5);
				tmBuscaCliente.setValueAt(clientes.get(i).getBairro(), i, 6);
				tmBuscaCliente.setValueAt(clientes.get(i).getEstado(), i, 7);
				tmBuscaCliente.setValueAt(clientes.get(i).getCidade(), i, 8);
			}
		}
	}
}
