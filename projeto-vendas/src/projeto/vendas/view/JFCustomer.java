package projeto.vendas.view;

import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import projeto.vendas.dao.CustomerDAO;
import projeto.vendas.model.Cidade;
import projeto.vendas.model.Customer;
import projeto.vendas.model.Estado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import projeto.vendas.dao.CustomerDAO;
import projeto.vendas.model.Customer;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JFCustomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2393976050363117949L;
	private JPanel jPContentCustomer;
	private final CustomerDAO controlCus;
	List<Customer> lsCliente;
	Customer customer;
	DefaultTableModel tmCliente = new DefaultTableModel(null, new String[] {
			"CPF", "NOME", "EMAIL", "TEL", "ENDEREÇO", "CEP", "BAIRRO",
			"ESTADO", "CIDADE" }) {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};

	private JPanel jPCliente;
	private JPanel jPListar;
	private JTabbedPane tabbedPaneCliente;
	private JScrollPane jScrollPaneListarCliente;
	private JTable jTableCliente;
	private JTextField jTPesquisar;
	private JButton jBPesquisar;
	private JPanel jPBotoes;
	private JButton jBNovo;
	private JButton jBSalvar;
	private JPanel jPDados;
	private JButton jBLimpar;
	private JFormattedTextField jFormattedCpf;
	private JLabel jLNomeCliente;
	private JTextField jTNomeCliente;
	private JLabel jLRg;
	private JTextField jTRg;
	private JLabel jLNomeMae;
	private JTextField jTNomeMae;
	private JLabel jLDataNasc;
	private JFormattedTextField jFormattedDataNasc;
	private JLabel jLNomePai;
	private JTextField jTNomePai;
	private JComboBox jCBEstadoCivil;
	private JLabel jLEmail;
	private JTextField jTEmail;
	private JTextField jTEndereco;
	private JTextField jTTelefone;
	private JTextField jTBairro;
	private JComboBox jCBSexo;
	private JLabel jLEstadoCivil;
	private JLabel jLSexo;
	private JLabel jLCpf;
	private JFormattedTextField jFormattedCep;
	private JComboBox jCBEstado;
	private JLabel jLCidade;
	private JLabel jLCep;
	private JComboBox jCBCidade;
	private JLabel jLEstado;
	private JLabel jLBairro;
	private JLabel jLEndereco;
	private JLabel jLTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCustomer frame = new JFCustomer();
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
	 * @throws ParseException
	 */
	public JFCustomer() throws SQLException, ParseException {
		initComponents();
		desabilitaDados();
		this.controlCus = new CustomerDAO();
		this.customer = new Customer();
		carregaJCEstado();
	}

	private void initComponents() throws ParseException {
		jPContentCustomer = new javax.swing.JPanel();
		tabbedPaneCliente = new javax.swing.JTabbedPane();
		jPCliente = new javax.swing.JPanel();
		jPListar = new javax.swing.JPanel();
		jScrollPaneListarCliente = new javax.swing.JScrollPane();
		jTableCliente = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPBotoes = new JPanel();
		jPBotoes.setBorder(new TitledBorder(null, "Bot\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		jPDados = new JPanel();
		jPDados.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		javax.swing.GroupLayout jPClienteLayout = new javax.swing.GroupLayout(
				jPCliente);
		jPClienteLayout
				.setHorizontalGroup(jPClienteLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								jPClienteLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPClienteLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																jPDados,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																895,
																Short.MAX_VALUE)
														.addComponent(
																jPBotoes,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																895,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPClienteLayout.setVerticalGroup(jPClienteLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				jPClienteLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPBotoes, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(jPDados, GroupLayout.DEFAULT_SIZE, 297,
								Short.MAX_VALUE).addContainerGap()));

		jLCpf = new JLabel("Cpf:");

		jFormattedCpf = new JFormattedTextField();
		jFormattedCpf
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.MaskFormatter("###.###.###-##")));

		jLNomeCliente = new JLabel("Nome Cliente:");

		jTNomeCliente = new JTextField();
		jTNomeCliente.setColumns(10);

		jLRg = new JLabel("RG:");

		jTRg = new JTextField();
		jTRg.setColumns(10);

		jLNomeMae = new JLabel("Nome M\u00E3e:");

		jTNomeMae = new JTextField();
		jTNomeMae.setColumns(10);

		jLDataNasc = new JLabel("Data Nasc:");

		jFormattedDataNasc = new JFormattedTextField();
		jFormattedDataNasc
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.MaskFormatter("##/##/####")));

		jLNomePai = new JLabel("Nome Pai:");

		jTNomePai = new JTextField();
		jTNomePai.setColumns(10);

		jLSexo = new JLabel("Sexo:");

		jCBSexo = new JComboBox();
		jCBSexo.setModel(new DefaultComboBoxModel(new String[] { "",
				"MASCULINO", "FEMININO" }));

		jLEstadoCivil = new JLabel("Estado Civil:");

		jCBEstadoCivil = new JComboBox();
		jCBEstadoCivil
				.setModel(new DefaultComboBoxModel(new String[] { "",
						"SOLTEIRO", "CASADO", "SEPARADO", "DIVORCIADO",
						"VI\u00DAVO" }));

		jLEmail = new JLabel("Email:");

		jTEmail = new JTextField();
		jTEmail.setColumns(10);

		jFormattedCep = new JFormattedTextField();
		jFormattedCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));

		jLCep = new JLabel("CEP:");

		jTEndereco = new JTextField();
		jTEndereco.setColumns(10);

		jLEstado = new JLabel("Estado:");

		jCBEstado = new JComboBox();

		jLCidade = new JLabel("Cidade:");

		jCBCidade = new JComboBox();

		jLEstado = new JLabel("Estado:");

		jTTelefone = new JTextField();
		jTTelefone.setColumns(10);

		jLBairro = new JLabel("Bairro:");

		jTBairro = new JTextField();
		jTBairro.setColumns(10);
		
		jLEndereco = new JLabel("Endere\u00E7o:");
		
		jLTelefone = new JLabel("Telefone:");

		GroupLayout gl_jPDados = new GroupLayout(jPDados);
		gl_jPDados.setHorizontalGroup(
			gl_jPDados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPDados.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPDados.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPDados.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_jPDados.createSequentialGroup()
								.addGroup(gl_jPDados.createParallelGroup(Alignment.LEADING)
									.addComponent(jLCpf)
									.addComponent(jLRg))
								.addGap(40)
								.addGroup(gl_jPDados.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(jFormattedCpf)
									.addComponent(jTRg, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
							.addGroup(gl_jPDados.createSequentialGroup()
								.addGroup(gl_jPDados.createParallelGroup(Alignment.LEADING)
									.addComponent(jLDataNasc)
									.addComponent(jLSexo)
									.addComponent(jLTelefone))
								.addGap(8)
								.addGroup(gl_jPDados.createParallelGroup(Alignment.LEADING)
									.addComponent(jCBSexo, 0, 140, Short.MAX_VALUE)
									.addComponent(jFormattedDataNasc)
									.addComponent(jFormattedCep, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
									.addComponent(jCBEstado, 0, 140, Short.MAX_VALUE)
									.addComponent(jTTelefone, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
						.addComponent(jLCep)
						.addComponent(jLEstado))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.LEADING)
						.addComponent(jLNomeCliente)
						.addComponent(jLNomeMae)
						.addComponent(jLNomePai)
						.addComponent(jLEstadoCivil)
						.addComponent(jLCidade)
						.addComponent(jLBairro)
						.addComponent(jLEndereco))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.LEADING)
						.addComponent(jTNomeMae, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
						.addComponent(jTNomeCliente, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
						.addComponent(jTNomePai, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
						.addGroup(gl_jPDados.createSequentialGroup()
							.addComponent(jCBEstadoCivil, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jLEmail)
							.addGap(18)
							.addComponent(jTEmail, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
						.addComponent(jTEndereco, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
						.addComponent(jCBCidade, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(jTBairro, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPDados.setVerticalGroup(
			gl_jPDados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPDados.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLCpf)
						.addComponent(jFormattedCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLNomeCliente)
						.addComponent(jTNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLRg)
						.addComponent(jTRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLNomeMae)
						.addComponent(jTNomeMae, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(jFormattedDataNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLDataNasc)
						.addComponent(jLNomePai)
						.addComponent(jTNomePai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLSexo)
						.addComponent(jCBSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLEstadoCivil)
						.addComponent(jCBEstadoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLEmail)
						.addComponent(jTEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(jFormattedCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLCep)
						.addComponent(jTEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLEndereco))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLEstado)
						.addComponent(jCBEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLCidade)
						.addComponent(jCBCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jPDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLEstado)
						.addComponent(jTTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLBairro)
						.addComponent(jTBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLTelefone))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		jPDados.setLayout(gl_jPDados);

		jBNovo = new JButton("Novo");
		jBNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				habilitaDados();
			}
		});
		jBNovo.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/novo.png")));

		jBSalvar = new JButton("Salvar");
		jBSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					salvarCliente();
					limparDados();
					desabilitaDados();
				} catch (SQLException | ParseException ex) {
					Logger.getLogger(JFCustomer.class.getName()).log(Level.SEVERE, null, ex.getMessage());
		            JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBSalvar.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/1428_32x32.png")));

		jBLimpar = new JButton("Limpar");
		jBLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparDados();
			}
		});
		jBLimpar.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/Eraser-32.png")));

		GroupLayout gl_jPBotoes = new GroupLayout(jPBotoes);
		gl_jPBotoes.setHorizontalGroup(gl_jPBotoes.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_jPBotoes
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jBNovo)
						.addGap(18)
						.addComponent(jBSalvar)
						.addPreferredGap(ComponentPlacement.RELATED, 570,
								Short.MAX_VALUE).addComponent(jBLimpar)
						.addContainerGap()));
		gl_jPBotoes
				.setVerticalGroup(gl_jPBotoes
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPBotoes
										.createSequentialGroup()
										.addGroup(
												gl_jPBotoes
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jBSalvar,
																GroupLayout.PREFERRED_SIZE,
																39,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBNovo,
																GroupLayout.DEFAULT_SIZE,
																38,
																Short.MAX_VALUE)
														.addComponent(jBLimpar))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPBotoes.setLayout(gl_jPBotoes);
		jPCliente.setLayout(jPClienteLayout);

		tabbedPaneCliente.addTab("Novo Cliente", jPCliente);

		jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPaneListarCliente.setViewportView(jTableCliente);

		jTPesquisar = new JTextField();
		jTPesquisar.setColumns(10);

		jBPesquisar = new JButton("Pesquisar");
		jBPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pesquisarCliente();
				} catch (SQLException ex) {
					Logger.getLogger(JFCustomer.class.getName()).log(
							Level.SEVERE, null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBPesquisar.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/1999_16x16.png")));

		javax.swing.GroupLayout jPListarLayout = new javax.swing.GroupLayout(
				jPListar);
		jPListarLayout
				.setHorizontalGroup(jPListarLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								jPListarLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPListarLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																jScrollPaneListarCliente,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																885,
																Short.MAX_VALUE)
														.addGroup(
																jPListarLayout
																		.createSequentialGroup()
																		.addComponent(
																				jTPesquisar,
																				GroupLayout.DEFAULT_SIZE,
																				778,
																				Short.MAX_VALUE)
																		.addGap(18)
																		.addComponent(
																				jBPesquisar)))
										.addContainerGap()));
		jPListarLayout
				.setVerticalGroup(jPListarLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								jPListarLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPListarLayout
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
										.addComponent(jScrollPaneListarCliente,
												GroupLayout.DEFAULT_SIZE, 289,
												Short.MAX_VALUE)
										.addContainerGap()));
		jPListar.setLayout(jPListarLayout);

		tabbedPaneCliente.addTab("Listar Cliente", jPListar);

		javax.swing.GroupLayout jPContentCustomerLayout = new javax.swing.GroupLayout(
				jPContentCustomer);
		jPContentCustomer.setLayout(jPContentCustomerLayout);
		jPContentCustomerLayout.setHorizontalGroup(jPContentCustomerLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPContentCustomerLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPaneCliente)
								.addContainerGap()));
		jPContentCustomerLayout.setVerticalGroup(jPContentCustomerLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPContentCustomerLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(tabbedPaneCliente)
								.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPContentCustomer,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPContentCustomer,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		pack();

		jTableCliente.setModel(tmCliente);
		arrumaTabela();

		jScrollPaneListarCliente.setViewportView(jTableCliente);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	public void arrumaTabela() {
		jTableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(85);
		jTableCliente.getColumnModel().getColumn(1).setPreferredWidth(220);
		jTableCliente.getColumnModel().getColumn(2).setPreferredWidth(140);
		jTableCliente.getColumnModel().getColumn(3).setPreferredWidth(80);
		jTableCliente.getColumnModel().getColumn(4).setPreferredWidth(220);
		jTableCliente.getColumnModel().getColumn(5).setPreferredWidth(60);
		jTableCliente.getColumnModel().getColumn(6).setPreferredWidth(100);
		jTableCliente.getColumnModel().getColumn(7).setPreferredWidth(50);
		jTableCliente.getColumnModel().getColumn(8).setPreferredWidth(60);
	}

	public final void desabilitaDados() {
		jFormattedCpf.setEnabled(false);
		jTNomeCliente.setEnabled(false);
		jTEmail.setEnabled(false);
		jTTelefone.setEnabled(false);
		jTEndereco.setEnabled(false);
		jFormattedCep.setEnabled(false);
		jTBairro.setEnabled(false);
		jCBEstado.setEnabled(false);
		jCBCidade.setEnabled(false);
		jTNomePai.setEnabled(false);
		jTNomeMae.setEnabled(false);
		jCBSexo.setEnabled(false);
		jCBEstadoCivil.setEnabled(false);
		jTRg.setEnabled(false);
		jFormattedDataNasc.setEnabled(false);
	}

	public final void habilitaDados() {
		jFormattedCpf.setEnabled(true);
		jTNomeCliente.setEnabled(true);
		jTEmail.setEnabled(true);
		jTTelefone.setEnabled(true);
		jTEndereco.setEnabled(true);
		jFormattedCep.setEnabled(true);
		jTBairro.setEnabled(true);
		jCBEstado.setEnabled(true);
		jCBCidade.setEnabled(true);
		jTNomePai.setEnabled(true);
		jTNomeMae.setEnabled(true);
		jCBSexo.setEnabled(true);
		jCBEstadoCivil.setEnabled(true);
		jTRg.setEnabled(true);
		jFormattedDataNasc.setEnabled(true);
	}

	public void limparDados() {
		jFormattedCpf.setText("");
		jTNomeCliente.setText("");
		jTEmail.setText("");
		jTTelefone.setText("");
		jTEndereco.setText("");
		jFormattedCep.setText("");
		jTBairro.setText("");
		jCBEstado.setSelectedItem(null);
		jCBCidade.setSelectedItem(null);
		jTNomePai.setText("");
		jTNomeMae.setText("");
		jCBSexo.setSelectedItem(null);
		jCBEstadoCivil.setSelectedItem(null);
		jTRg.setText("");
		jFormattedDataNasc.setText("");
	}

	public boolean verificaDados() {
		if (jFormattedCpf.getText().equals("") || jTNomeCliente.getText().equals("")
				|| jTRg.getText().equals("") || jTNomeMae.getText().equals("")
				|| jFormattedDataNasc.getText().equals("")
				|| jTNomePai.getText().equals("")
				|| jCBSexo.getSelectedItem().toString().equals("")
				|| jCBEstadoCivil.getSelectedItem().toString().equals("")
				|| jTEmail.getText().equals("") || jFormattedCep.getText().equals("")
				|| jTEndereco.getText().equals("")
				|| jCBEstado.getSelectedItem().toString().equals("")
				|| jCBCidade.getSelectedItem().toString().equals("")
				|| jTTelefone.getText().equals("")
				|| jTBairro.getText().equals("")) {
			JOptionPane.showMessageDialog(this,
					"Campos do cliente não podem ser vazios");
			return false;
		} else {
			return true;
		}
	}

	public void carregaJCEstado() throws SQLException {
		List<Estado> estados = controlCus.listaEstados();

		for (Estado estado : estados) {
			jCBEstado.addItem(estado.getNome_estado());
		}

		jCBEstado.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						jCBCidade.removeAllItems();
						carregaJBCidade();
					}

				} catch (SQLException ex) {
					Logger.getLogger(JFCustomer.class.getName()).log(
							Level.SEVERE, null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});

	}

	public void carregaJBCidade() throws SQLException {
		List<Cidade> cd = controlCus.listaCidades(jCBEstado.getSelectedItem()
				.toString());

		for (int i = 0; i < cd.size(); i++) {
			jCBCidade.addItem(cd.get(i).getNome_cidade());
		}
	}

	public void salvarCliente() throws SQLException, ParseException {

		customer = new Customer(Long.parseLong(jFormattedCpf.getText().replace(".", "")
				.replace("-", "")),
				jCBEstadoCivil.getSelectedItem().toString(), jCBSexo
						.getSelectedItem().toString(), jTNomeCliente.getText()
						.toUpperCase(), jTRg.getText(),
				customer.convertToDate(jFormattedDataNasc.getText()), jTEndereco
						.getText().toUpperCase(), Long.parseLong(jFormattedCep
						.getText().replace(".", "").replace("-", "")),
				jTNomeMae.getText().toUpperCase(), jTNomePai.getText()
						.toUpperCase(), Long.parseLong(jTTelefone.getText()),
				jCBEstado.getSelectedItem().toString(), jCBCidade
						.getSelectedItem().toString(), jTEmail.getText()
						.toUpperCase(), jTBairro.getText().toUpperCase());

		controlCus.cadastrarCliente(customer);
		JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
	}

	public void pesquisarCliente() throws SQLException {
		lsCliente = controlCus.listarCliente("%"
				+ jTPesquisar.getText().toUpperCase() + "%");
		mostrarCliente(lsCliente);
	}

	public void mostrarCliente(List<Customer> clientes) {

		while (tmCliente.getRowCount() > 0) {
			tmCliente.removeRow(0);
		}

		if (clientes.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Nenhum resultado obtido");
		} else {
			String[] linha = new String[] { null, null, null, null, null, null,
					null, null, null };
			for (int i = 0; i < clientes.size(); i++) {
				tmCliente.addRow(linha);
				tmCliente.setValueAt(clientes.get(i).getCpf(), i, 0);
				tmCliente.setValueAt(clientes.get(i).getNome_cliente(), i, 1);
				tmCliente.setValueAt(clientes.get(i).getEmail(), i, 2);
				tmCliente.setValueAt(clientes.get(i).getTelefone(), i, 3);
				tmCliente.setValueAt(clientes.get(i).getEndereco(), i, 4);
				tmCliente.setValueAt(clientes.get(i).getCep(), i, 5);
				tmCliente.setValueAt(clientes.get(i).getBairro(), i, 6);
				tmCliente.setValueAt(clientes.get(i).getEstado(), i, 7);
				tmCliente.setValueAt(clientes.get(i).getCidade(), i, 8);
			}
		}
	}
}
