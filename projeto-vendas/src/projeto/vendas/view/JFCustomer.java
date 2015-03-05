package projeto.vendas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class JFCustomer extends JFrame {

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1168767098000571102L;
	private JPanel jPContentCustomer;
	private JPanel jPCliente;
	private JPanel jPListar;
	private JTabbedPane tabbedPaneCliente;
	private JPanel jPBotoes;
	private JButton jBNovo;
	private JButton jbSalvar;
	private JButton jBLimpar;
	private JPanel jPDadosCliente;
	private JLabel jLCpf;
	private JFormattedTextField jFormattedCpf;
	private JLabel jLNomeCliente;
	private JTextField jTNomeCliente;
	private JLabel jLRg;
	private JTextField jTRg;
	private JLabel jLNomeMae;
	private JTextField jTNomeMae;
	private JButton jBPesquisar;
	private JTextField jTPesquisar;
	private JScrollPane jScrollPaneListarCliente;
	private JTable jTableCliente;
	private JTextField jTNomePai;
	private JTextField jTEmail;
	private JLabel jLDataNasc;
	private JFormattedTextField jFormattedDataNasc;
	private JLabel jLSexo;
	private JComboBox jCSexo;
	private JLabel jLEstadoCivil;
	private JLabel jLNomePai;
	private JComboBox jCEstadoCivil;
	private JLabel jLEmail;
	private JLabel jLCep;
	private JFormattedTextField jFormattedCep;
	private JLabel jLEndereco;
	private JTextField jTEndereco;
	private JLabel jLEstado;
	private JComboBox jCEstado;
	private JLabel jLCidade;
	private JComboBox jCCidade;
	private JLabel jLTelefone;
	private JTextField jTTelefone;
	private JLabel jLBairro;
	private JTextField jTBairro;

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
	 * @throws ParseException
	 * @throws SQLException
	 */
	public JFCustomer() throws ParseException, SQLException {
		initComponents();
		desabilitaDados();
		this.controlCus = new CustomerDAO();
		carregaJCEstado();
	}

	private void initComponents() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 471);
		jPContentCustomer = new JPanel();
		jPContentCustomer.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPContentCustomer);
		jPContentCustomer.setLayout(new BorderLayout(0, 0));

		tabbedPaneCliente = new JTabbedPane(JTabbedPane.LEFT);
		jPContentCustomer.add(tabbedPaneCliente, BorderLayout.CENTER);

		jPCliente = new JPanel();
		tabbedPaneCliente.addTab("Novo Cliente", null, jPCliente, null);
		jPCliente.setLayout(null);

		jPBotoes = new JPanel();
		jPBotoes.setBorder(new TitledBorder(null, "Bot\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPBotoes.setBounds(10, 11, 671, 92);
		jPCliente.add(jPBotoes);
		jPBotoes.setLayout(null);

		jBNovo = new JButton("Novo");
		jBNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					habilitaDados();
			}
		});
		jBNovo.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/novo.png")));
		jBNovo.setBounds(10, 23, 106, 40);
		jPBotoes.add(jBNovo);

		jbSalvar = new JButton("Salvar");
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (verificaDados()) {
						salvarCliente();
						limparDados();
						desabilitaDados();
					}
					
				} catch (SQLException | ParseException e1) {
					Logger.getLogger(JFCustomer.class.getName()).log(
							Level.SEVERE, null, e1.getMessage());
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		jbSalvar.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/1428_32x32.png")));
		jbSalvar.setBounds(126, 23, 106, 40);
		jPBotoes.add(jbSalvar);

		jBLimpar = new JButton("Limpar");
		jBLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparDados();
			}
		});
		jBLimpar.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/Eraser-32.png")));
		jBLimpar.setBounds(555, 23, 106, 40);
		jPBotoes.add(jBLimpar);

		jPDadosCliente = new JPanel();
		jPDadosCliente.setBorder(new TitledBorder(null, "Dados",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPDadosCliente.setBounds(10, 114, 671, 292);
		jPCliente.add(jPDadosCliente);
		jPDadosCliente.setLayout(null);

		jLCpf = new JLabel("CPF:");
		jLCpf.setBounds(10, 32, 28, 14);
		jPDadosCliente.add(jLCpf);

		jFormattedCpf = new JFormattedTextField();
		jFormattedCpf.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("###.###.###-##")));
		jFormattedCpf.setBounds(77, 29, 98, 20);
		jPDadosCliente.add(jFormattedCpf);

		jLNomeCliente = new JLabel("Nome Cliente:");
		jLNomeCliente.setBounds(196, 32, 67, 14);
		jPDadosCliente.add(jLNomeCliente);

		jTNomeCliente = new JTextField();
		jTNomeCliente.setBounds(273, 29, 388, 20);
		jPDadosCliente.add(jTNomeCliente);
		jTNomeCliente.setColumns(10);

		jLRg = new JLabel("RG:");
		jLRg.setBounds(10, 70, 28, 14);
		jPDadosCliente.add(jLRg);

		jTRg = new JTextField();
		jTRg.setBounds(77, 67, 98, 20);
		jPDadosCliente.add(jTRg);
		jTRg.setColumns(10);

		jLNomeMae = new JLabel("Nome M\u00E3e:");
		jLNomeMae.setBounds(196, 70, 67, 14);
		jPDadosCliente.add(jLNomeMae);

		jTNomeMae = new JTextField();
		jTNomeMae.setBounds(273, 67, 388, 20);
		jPDadosCliente.add(jTNomeMae);
		jTNomeMae.setColumns(10);

		jLDataNasc = new JLabel("Data Nasc:");
		jLDataNasc.setBounds(10, 105, 54, 14);
		jPDadosCliente.add(jLDataNasc);

		jLNomePai = new JLabel("Nome Pai:");
		jLNomePai.setBounds(196, 105, 54, 14);
		jPDadosCliente.add(jLNomePai);

		jTNomePai = new JTextField();
		jTNomePai.setBounds(273, 102, 388, 20);
		jPDadosCliente.add(jTNomePai);
		jTNomePai.setColumns(10);

		jFormattedDataNasc = new JFormattedTextField();
		jFormattedDataNasc.setBounds(77, 102, 98, 20);
		jFormattedDataNasc
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.MaskFormatter("##/##/####")));
		jPDadosCliente.add(jFormattedDataNasc);

		jLSexo = new JLabel("Sexo:");
		jLSexo.setBounds(10, 140, 46, 14);
		jPDadosCliente.add(jLSexo);

		jCSexo = new JComboBox();
		jCSexo.setModel(new DefaultComboBoxModel(new String[] { "",
				"MASCULINO", "FEMININO" }));
		jCSexo.setBounds(77, 137, 98, 20);
		jPDadosCliente.add(jCSexo);

		jLEstadoCivil = new JLabel("Estado Civil:");
		jLEstadoCivil.setBounds(196, 140, 67, 14);
		jPDadosCliente.add(jLEstadoCivil);

		jCEstadoCivil = new JComboBox();
		jCEstadoCivil
				.setModel(new DefaultComboBoxModel(new String[] { "",
						"SOLTEIRO", "CASADO", "DIVORCIADO", "SEPARADO",
						"VI\u00DAVO" }));
		jCEstadoCivil.setBounds(273, 137, 98, 20);
		jPDadosCliente.add(jCEstadoCivil);

		jLEmail = new JLabel("Email:");
		jLEmail.setBounds(398, 140, 46, 14);
		jPDadosCliente.add(jLEmail);

		jTEmail = new JTextField();
		jTEmail.setBounds(454, 137, 207, 20);
		jPDadosCliente.add(jTEmail);
		jTEmail.setColumns(10);

		jLCep = new JLabel("CEP:");
		jLCep.setBounds(10, 175, 46, 14);
		jPDadosCliente.add(jLCep);

		jFormattedCep = new JFormattedTextField();
		jFormattedCep.setBounds(77, 172, 98, 20);
		jFormattedCep
				.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.MaskFormatter("##.###-###")));
		jPDadosCliente.add(jFormattedCep);

		jLEndereco = new JLabel("Endere\u00E7o:");
		jLEndereco.setBounds(196, 175, 54, 14);
		jPDadosCliente.add(jLEndereco);

		jTEndereco = new JTextField();
		jTEndereco.setBounds(273, 172, 388, 20);
		jPDadosCliente.add(jTEndereco);
		jTEndereco.setColumns(10);

		jLEstado = new JLabel("Estado:");
		jLEstado.setBounds(10, 210, 46, 14);
		jPDadosCliente.add(jLEstado);

		jCEstado = new JComboBox();
		jCEstado.setBounds(77, 207, 98, 20);
		jPDadosCliente.add(jCEstado);

		jLCidade = new JLabel("Cidade:");
		jLCidade.setBounds(196, 210, 46, 14);
		jPDadosCliente.add(jLCidade);

		jCCidade = new JComboBox();
		jCCidade.setBounds(273, 207, 233, 20);
		jPDadosCliente.add(jCCidade);

		jLTelefone = new JLabel("Telefone:");
		jLTelefone.setBounds(10, 245, 46, 14);
		jPDadosCliente.add(jLTelefone);

		jTTelefone = new JTextField();
		jTTelefone.setBounds(77, 242, 98, 20);
		jPDadosCliente.add(jTTelefone);
		jTTelefone.setColumns(10);

		jLBairro = new JLabel("Bairro:");
		jLBairro.setBounds(196, 245, 46, 14);
		jPDadosCliente.add(jLBairro);

		jTBairro = new JTextField();
		jTBairro.setBounds(273, 242, 388, 20);
		jPDadosCliente.add(jTBairro);
		jTBairro.setColumns(10);

		jPListar = new JPanel();
		tabbedPaneCliente.addTab("Listar Cliente", null, jPListar, null);
		jPListar.setLayout(null);

		jBPesquisar = new JButton("Pesquisar");
		jBPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pesquisarCliente();
				} catch (SQLException ex) {
					Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE,
							null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBPesquisar.setIcon(new ImageIcon(JFCustomer.class
				.getResource("/projeto/vendas/images/1999_16x16.png")));
		jBPesquisar.setBounds(576, 11, 105, 23);
		jPListar.add(jBPesquisar);

		jTPesquisar = new JTextField();
		jTPesquisar.setBounds(10, 12, 556, 20);
		jPListar.add(jTPesquisar);
		jTPesquisar.setColumns(10);

		jScrollPaneListarCliente = new JScrollPane();
		jScrollPaneListarCliente.setBounds(10, 43, 1071, 363);
		jPListar.add(jScrollPaneListarCliente);

		jTableCliente = new JTable();
		jTableCliente.setModel(tmCliente);
		arrumaTabela();
		jScrollPaneListarCliente.setViewportView(jTableCliente);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	public final void desabilitaDados() {
		jFormattedCpf.setEnabled(false);
		jTNomeCliente.setEnabled(false);
		jTEmail.setEnabled(false);
		jTTelefone.setEnabled(false);
		jTEndereco.setEnabled(false);
		jFormattedCep.setEnabled(false);
		jTBairro.setEnabled(false);
		jCEstado.setEnabled(false);
		jCCidade.setEnabled(false);
		jTNomePai.setEnabled(false);
		jTNomeMae.setEnabled(false);
		jCSexo.setEnabled(false);
		jCEstadoCivil.setEnabled(false);
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
		jCEstado.setEnabled(true);
		jCCidade.setEnabled(true);
		jTNomePai.setEnabled(true);
		jTNomeMae.setEnabled(true);
		jCSexo.setEnabled(true);
		jCEstadoCivil.setEnabled(true);
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
		jCEstado.setSelectedItem(null);
		jCCidade.setSelectedItem(null);
		jTNomePai.setText("");
		jTNomeMae.setText("");
		jCSexo.setSelectedItem(null);
		jCEstadoCivil.setSelectedItem(null);
		jTRg.setText("");
		jFormattedDataNasc.setText("");
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
	
	public void arrumaTabela() {
		jTableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(90);
		jTableCliente.getColumnModel().getColumn(1).setPreferredWidth(210);
		jTableCliente.getColumnModel().getColumn(2).setPreferredWidth(140);
	}

	public boolean verificaDados() {
		if (jFormattedCpf.getText().equals("")
				|| jTNomeCliente.getText().equals("")
				|| jTRg.getText().equals("") || jTNomeMae.getText().equals("")
				|| jFormattedDataNasc.getText().equals("")
				|| jTNomePai.getText().equals("")
				|| jCSexo.getSelectedItem().toString().equals("")
				|| jCEstadoCivil.getSelectedItem().toString().equals("")
				|| jTEmail.getText().equals("")
				|| jFormattedCep.getText().equals("")
				|| jTEndereco.getText().equals("")
				|| jCEstado.getSelectedItem().toString().equals("")
				|| jCCidade.getSelectedItem().toString().equals("")
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
			jCEstado.addItem(estado.getNome_estado());
		}

		jCEstado.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						jCCidade.removeAllItems();
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
		List<Cidade> cd = controlCus.listaCidades(jCEstado.getSelectedItem()
				.toString());

		for (int i = 0; i < cd.size(); i++) {
			jCCidade.addItem(cd.get(i).getNome_cidade());
		}
	}

	public void salvarCliente() throws SQLException, ParseException {

		customer = new Customer(Long.parseLong(jFormattedCpf.getText()
				.replace(".", "").replace("-", "")), jCEstadoCivil
				.getSelectedItem().toString(), jCSexo.getSelectedItem()
				.toString(), jTNomeCliente.getText().toUpperCase(),
				jTRg.getText(), customer.convertToDate(jFormattedDataNasc
						.getText()), jTEndereco.getText().toUpperCase(),
				Long.parseLong(jFormattedCep.getText().replace(".", "")
						.replace("-", "")), jTNomeMae.getText().toUpperCase(),
				jTNomePai.getText().toUpperCase(), Long.parseLong(jTTelefone
						.getText()), jCEstado.getSelectedItem().toString(),
				jCCidade.getSelectedItem().toString(), jTEmail.getText()
						.toUpperCase(), jTBairro.getText().toUpperCase());

		controlCus.cadastrarCliente(customer);
		JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
	}
}
