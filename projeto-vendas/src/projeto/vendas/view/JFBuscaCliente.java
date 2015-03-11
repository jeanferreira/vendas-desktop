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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFBuscaCliente extends JFrame {
	
	DefaultTableModel tmBuscaCliente = new DefaultTableModel(null,
			new String[] { "CPF", "NOME CLIENTE", "RG", "NOME MÃE", "DATA NASC", "NOME PAI",
					"TELEFONE", "SEXO", "ESTADO CIVIL", "EMAIL", "ENDEREÇO", "BAIRRO", "CEP", "ESTADO", "CIDADE" }) {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};

	private static JFBuscaCliente INSTANCIA_BUSCA_CLIENTE;
	private final CustomerDAO controlCus;
	List<Customer> lsCliente;
	private static JFVenda jfvenda ;
	
	private static final long serialVersionUID = 6003519484200486878L;
	private JPanel contentPane;
	private JButton jBPesquisar;
	private JTextField jTPesquisar;
	private JPanel jPContentBuscaCliente;
	private JTable jTableBuscaCliente;
	private JScrollPane jScrollPaneCliente;

	public JFBuscaCliente(JFVenda jfvenda) throws SQLException {
		initComponents();
		this.controlCus = new CustomerDAO();
		this.jfvenda = jfvenda;
	}
	
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFBuscaCliente.class.getResource("/projeto/vendas/images/cer_btn12.png")));
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
		arrumaTabela();
		jTableBuscaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JFVenda frame = jfvenda;
					frame.getjTCpf().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 0).toString());
					frame.getjTNomeCliente().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 1).toString());
					frame.getjTRg().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 2).toString());
					frame.getjTNomeMae().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 3).toString());
					frame.getjTDataNasc().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 4).toString());
					frame.getjTNomePai().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 5).toString());
					frame.getjTTelefone().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 6).toString());
					frame.getjTSexo().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 7).toString());
					frame.getjTEstadoCivil().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 8).toString());
					frame.getjTEmail().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 9).toString());
					frame.getjTEndereco().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 10).toString());
					frame.getjTBairro().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 11).toString());
					frame.getjTCep().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 12).toString());
					frame.getjTEstado().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 13).toString());
					frame.getjTCidade().setText(jTableBuscaCliente.getModel().getValueAt(jTableBuscaCliente.getSelectedRow(), 14).toString());
					dispose();
					frame.setVisible(true);
				}
			}
		});
		
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

	
	public static synchronized JFBuscaCliente getInstance() throws SQLException {
		if (INSTANCIA_BUSCA_CLIENTE == null) {
			INSTANCIA_BUSCA_CLIENTE = new JFBuscaCliente(jfvenda);
		}
		return INSTANCIA_BUSCA_CLIENTE;
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
					null, null, null, null, null, null, null, null, null};
			for (int i = 0; i < clientes.size(); i++) {
				tmBuscaCliente.addRow(linha);
				tmBuscaCliente.setValueAt(clientes.get(i).getCpf(), i, 0);
				tmBuscaCliente.setValueAt(clientes.get(i).getNome_cliente(), i,
						1);
				tmBuscaCliente.setValueAt(clientes.get(i).getRg(), i, 2);
				tmBuscaCliente.setValueAt(clientes.get(i).getNome_mae(), i, 3);
				tmBuscaCliente.setValueAt(clientes.get(i).getDataNasc(), i, 4);
				tmBuscaCliente.setValueAt(clientes.get(i).getNome_pai(), i, 5);
				tmBuscaCliente.setValueAt(clientes.get(i).getTelefone(), i, 6);
				tmBuscaCliente.setValueAt(clientes.get(i).getSexo(), i, 7);
				tmBuscaCliente.setValueAt(clientes.get(i).getEstado_civil(), i, 8);
				tmBuscaCliente.setValueAt(clientes.get(i).getEmail(), i, 9);
				tmBuscaCliente.setValueAt(clientes.get(i).getEndereco(), i, 10);
				tmBuscaCliente.setValueAt(clientes.get(i).getBairro(), i, 11);
				tmBuscaCliente.setValueAt(clientes.get(i).getCep(), i, 12);
				tmBuscaCliente.setValueAt(clientes.get(i).getEstado(), i, 13);
				tmBuscaCliente.setValueAt(clientes.get(i).getCidade(), i, 14);
				
			}
		}
	}
	
	public void arrumaTabela() {
		jTableBuscaCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableBuscaCliente.getColumnModel().getColumn(0).setPreferredWidth(85);
		jTableBuscaCliente.getColumnModel().getColumn(1).setPreferredWidth(230);
		jTableBuscaCliente.getColumnModel().getColumn(2).setPreferredWidth(70);
		jTableBuscaCliente.getColumnModel().getColumn(3).setPreferredWidth(230);
		jTableBuscaCliente.getColumnModel().getColumn(4).setPreferredWidth(70);
		jTableBuscaCliente.getColumnModel().getColumn(5).setPreferredWidth(200);
		jTableBuscaCliente.getColumnModel().getColumn(6).setPreferredWidth(80);
		jTableBuscaCliente.getColumnModel().getColumn(7).setPreferredWidth(70);
		jTableBuscaCliente.getColumnModel().getColumn(9).setPreferredWidth(160);
		jTableBuscaCliente.getColumnModel().getColumn(10).setPreferredWidth(200);
		jTableBuscaCliente.getColumnModel().getColumn(11).setPreferredWidth(150);
		jTableBuscaCliente.getColumnModel().getColumn(12).setPreferredWidth(70);
		jTableBuscaCliente.getColumnModel().getColumn(13).setPreferredWidth(70);
		jTableBuscaCliente.getColumnModel().getColumn(14).setPreferredWidth(70);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFBuscaCliente frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
