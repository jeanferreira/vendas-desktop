package projeto.vendas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.JSeparator;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JFVenda extends JFrame {

	DefaultTableModel tmProduto = new DefaultTableModel(null, new String[] {
			"COD", "TIPO", "NOME", "PRE�O" }) {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};

	private static JFVenda INSTANCIA_VENDA;

	private JPanel jPContentVenda;
	private JTabbedPane jTabbedPaneVendas;
	private JPanel jPVenda;
	private JPanel jPDadosCliente;
	private JLabel jLCpf;
	private JFormattedTextField jTCpf;
	private JButton jBBuscarCliente;
	private JLabel jLNomeCliente;
	private JTextField jTNomeCliente;
	private JLabel jLNomeMae;
	private JTextField jTNomeMae;

	private JFBuscaCliente jfbuscacliente;
	private JFBuscaProduto jfbuscaproduto;
	private JLabel jLRg;
	private JTextField jTRg;
	private JLabel jLDataNasc;
	private JFormattedTextField jTDataNasc;
	private JLabel jLNomePai;
	private JTextField jTNomePai;
	private JLabel jLTelefone;
	private JTextField jTTelefone;
	private JLabel jLSexo;
	private JTextField jTSexo;
	private JLabel jLEstadoCivil;
	private JTextField jTEstadoCivil;
	private JLabel jLEmail;
	private JTextField jTEmail;
	private JLabel jLEndereco;
	private JTextField jTEndereco;
	private JLabel jLBairro;
	private JTextField jTBairro;
	private JLabel jLCep;
	private JLabel jLEstado;
	private JLabel jLCidade;
	private JTextField jTCidade;
	private JTextField jTEstado;
	private JPanel jPDadosProduto;
	private JLabel jLCodProduto;
	private JTextField jTCodProduto;
	private JButton jBBuscaProduto;
	private JScrollPane jScrollPaneProduto;
	private JSeparator jSeparatorVenda;
	private JLabel jLDataVenda;
	private JFormattedTextField jTDataVenda;
	private JLabel jLTotal;
	private JFormattedTextField jTTotal;
	private JButton jBFinalizarVenda;
	private JTable jTableProduto;
	private JFormattedTextField jTCep;

	public JFVenda() throws ParseException {
		initComponents();
		desabilitaDados();
	}

	public JFormattedTextField getjTCep() {
		return jTCep;
	}

	public void setjTCep(JFormattedTextField jTCep) {
		this.jTCep = jTCep;
	}
	
	public JFormattedTextField getjTCpf() {
		return jTCpf;
	}

	public void setjTCpf(JFormattedTextField jTCpf) {
		this.jTCpf = jTCpf;
	}

	public JTextField getjTNomeCliente() {
		return jTNomeCliente;
	}

	public void setjTNomeCliente(JTextField jTNomeCliente) {
		this.jTNomeCliente = jTNomeCliente;
	}

	public JTextField getjTNomeMae() {
		return jTNomeMae;
	}

	public void setjTNomeMae(JTextField jTNomeMae) {
		this.jTNomeMae = jTNomeMae;
	}

	public JTextField getjTRg() {
		return jTRg;
	}

	public void setjTRg(JTextField jTRg) {
		this.jTRg = jTRg;
	}

	public JFormattedTextField getjTDataNasc() {
		return jTDataNasc;
	}

	public void setjTDataNasc(JFormattedTextField jTDataNasc) {
		this.jTDataNasc = jTDataNasc;
	}

	public JTextField getjTNomePai() {
		return jTNomePai;
	}

	public void setjTNomePai(JTextField jTNomePai) {
		this.jTNomePai = jTNomePai;
	}

	public JTextField getjTTelefone() {
		return jTTelefone;
	}

	public void setjTTelefone(JTextField jTTelefone) {
		this.jTTelefone = jTTelefone;
	}

	public JTextField getjTSexo() {
		return jTSexo;
	}

	public void setjTSexo(JTextField jTSexo) {
		this.jTSexo = jTSexo;
	}

	public JTextField getjTEstadoCivil() {
		return jTEstadoCivil;
	}

	public void setjTEstadoCivil(JTextField jTEstadoCivil) {
		this.jTEstadoCivil = jTEstadoCivil;
	}

	public JTextField getjTEmail() {
		return jTEmail;
	}

	public void setjTEmail(JTextField jTEmail) {
		this.jTEmail = jTEmail;
	}

	public JTextField getjTEndereco() {
		return jTEndereco;
	}

	public void setjTEndereco(JTextField jTEndereco) {
		this.jTEndereco = jTEndereco;
	}

	public JTextField getjTBairro() {
		return jTBairro;
	}

	public void setjTBairro(JTextField jTBairro) {
		this.jTBairro = jTBairro;
	}


	public JTextField getjTCidade() {
		return jTCidade;
	}

	public void setjTCidade(JTextField jTCidade) {
		this.jTCidade = jTCidade;
	}

	public JTextField getjTEstado() {
		return jTEstado;
	}

	public void setjTEstado(JTextField jTEstado) {
		this.jTEstado = jTEstado;
	}

	public JTextField getjTCodProduto() {
		return jTCodProduto;
	}

	public void setjTCodProduto(JTextField jTCodProduto) {
		this.jTCodProduto = jTCodProduto;
	}

	public JFormattedTextField getjTDataVenda() {
		return jTDataVenda;
	}

	public void setjTDataVenda(JFormattedTextField jTDataVenda) {
		this.jTDataVenda = jTDataVenda;
	}

	public JTable getjTableProduto() {
		return jTableProduto;
	}

	public void setjTableProduto(JTable jTableProduto) {
		this.jTableProduto = jTableProduto;
	}
	
	public DefaultTableModel getTmProduto() {
		return tmProduto;
	}

	public void setTmProduto(DefaultTableModel tmProduto) {
		this.tmProduto = tmProduto;
	}

	public static synchronized JFVenda getInstance() throws ParseException {
		if (INSTANCIA_VENDA == null) {
			INSTANCIA_VENDA = new JFVenda();
		}
		return INSTANCIA_VENDA;
	}

	private void initComponents() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFVenda.class
						.getResource("/projeto/vendas/images/cer_btn12.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 599);
		jPContentVenda = new JPanel();
		jPContentVenda.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPContentVenda);

		jTabbedPaneVendas = new JTabbedPane(JTabbedPane.LEFT);
		GroupLayout gl_jPContentVenda = new GroupLayout(jPContentVenda);
		gl_jPContentVenda.setHorizontalGroup(gl_jPContentVenda
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_jPContentVenda
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jTabbedPaneVendas,
										GroupLayout.DEFAULT_SIZE, 749,
										Short.MAX_VALUE).addContainerGap()));
		gl_jPContentVenda.setVerticalGroup(gl_jPContentVenda
				.createParallelGroup(Alignment.LEADING).addGroup(
						gl_jPContentVenda
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jTabbedPaneVendas,
										GroupLayout.DEFAULT_SIZE, 394,
										Short.MAX_VALUE).addContainerGap()));

		jPVenda = new JPanel();
		jTabbedPaneVendas.addTab("Nova Venda", null, jPVenda, null);

		jPDadosCliente = new JPanel();
		jPDadosCliente.setBorder(new TitledBorder(null, "Dados Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		jPDadosProduto = new JPanel();
		jPDadosProduto.setBorder(new TitledBorder(null, "Dados Produto",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		jSeparatorVenda = new JSeparator();

		jLDataVenda = new JLabel("Data Venda:");

		jTDataVenda = new JFormattedTextField();

		jLTotal = new JLabel("Total:");

		jTTotal = new JFormattedTextField();

		jBFinalizarVenda = new JButton("Finalizar Venda");
		jBFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser open = new JFileChooser();
				if (arg0.getSource() == jBFinalizarVenda) {
					int op = open.showSaveDialog(null);
					if (op == JFileChooser.APPROVE_OPTION) {
						File arq = open.getSelectedFile();
						String path = arq.toString();
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(path));
							bw.write("CPF" + ";" + jTCpf.getText() + "\n" + "NOME CLIENTE" + ";" + jTNomeCliente.getText() + "\n"
									+ "RG" + ";" + jTRg.getText() + "\n"
									+ "NOME M�E" + ";" + jTNomeMae.getText() + "\n"
									+ "DATA NASCIMENTO" + ";" + jTDataNasc.getText() + "\n"
									+ "NOME PAI" + ";" + jTNomePai.getText() + "\n"
									+ "TELEFONE" + ";" + jTTelefone.getText() + "\n"
									+ "SEXO" + ";" + jTSexo.getText() + "\n"
									+ "ESTADO CIVIL" + ";" + jTEstadoCivil.getText() + "\n"
									+ "EMAIL" + ";" + jTEmail.getText() + "\n"
									+ "ENDERE�O" + ";" + jTEndereco.getText() + "\n"
									+ "BAIRRO:" + ";" + jTBairro.getText() + "\n"
									+ "CEP" + ";" + jTCep.getText() + "\n"
									+ "ESTADO" + ";" + jTEstado.getText() + "\n"
									+ "CIDADE" + ";" + jTCidade.getText());
							bw.close();
							JOptionPane.showMessageDialog(null, "Venda Gerada com Sucesso");
						} catch (IOException ex) {
							Logger.getLogger(JFProduto.class.getName()).log(
									Level.SEVERE, null, ex.getMessage());
							JOptionPane.showMessageDialog(null, ex);
						}
					}
				}
			}
		});
		jBFinalizarVenda
				.setIcon(new ImageIcon(
						JFVenda.class
								.getResource("/projeto/vendas/images/finalizarVenda25X25.png")));
		GroupLayout gl_jPVenda = new GroupLayout(jPVenda);
		gl_jPVenda
				.setHorizontalGroup(gl_jPVenda
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPVenda
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPVenda
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jPVenda
																		.createSequentialGroup()
																		.addComponent(
																				jLDataVenda)
																		.addGap(18)
																		.addComponent(
																				jTDataVenda,
																				GroupLayout.PREFERRED_SIZE,
																				116,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				jLTotal)
																		.addGap(18)
																		.addComponent(
																				jTTotal,
																				GroupLayout.PREFERRED_SIZE,
																				132,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				252,
																				Short.MAX_VALUE)
																		.addComponent(
																				jBFinalizarVenda))
														.addComponent(
																jSeparatorVenda,
																GroupLayout.DEFAULT_SIZE,
																731,
																Short.MAX_VALUE)
														.addComponent(
																jPDadosProduto,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPDadosCliente,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(21)));
		gl_jPVenda
				.setVerticalGroup(gl_jPVenda
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPVenda
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jPDadosCliente,
												GroupLayout.PREFERRED_SIZE,
												209, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jPDadosProduto,
												GroupLayout.PREFERRED_SIZE,
												182, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(jSeparatorVenda,
												GroupLayout.PREFERRED_SIZE, 8,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												gl_jPVenda
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jLDataVenda)
														.addComponent(
																jTDataVenda,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jLTotal)
														.addComponent(
																jTTotal,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBFinalizarVenda))
										.addContainerGap(39, Short.MAX_VALUE)));

		jLCodProduto = new JLabel("Cod Produto:");

		jTCodProduto = new JTextField();
		jTCodProduto.setColumns(10);

		jBBuscaProduto = new JButton("Buscar");
		jBBuscaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jfbuscaproduto == null) {
					try {
						jfbuscaproduto = new JFBuscaProduto();
						jfbuscaproduto.setVisible(true);
						jfbuscaproduto.populaProduto(getInstance());
					} catch (SQLException | ParseException ex) {
						Logger.getLogger(JFProduto.class.getName()).log(
								Level.SEVERE, null, ex.getMessage());
						JOptionPane.showMessageDialog(null, ex);
					}
				} else {
					jfbuscaproduto.setVisible(true);
				}
			}
		});
		jBBuscaProduto.setIcon(new ImageIcon(JFVenda.class
				.getResource("/projeto/vendas/images/1999_16x16.png")));

		jTableProduto = new JTable();
		jTableProduto.setModel(tmProduto);

		jScrollPaneProduto = new JScrollPane();
		jScrollPaneProduto.setViewportView(jTableProduto);

		GroupLayout gl_jPDadosProduto = new GroupLayout(jPDadosProduto);
		gl_jPDadosProduto
				.setHorizontalGroup(gl_jPDadosProduto
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPDadosProduto
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPDadosProduto
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																jScrollPaneProduto,
																GroupLayout.DEFAULT_SIZE,
																699,
																Short.MAX_VALUE)
														.addGroup(
																gl_jPDadosProduto
																		.createSequentialGroup()
																		.addComponent(
																				jLCodProduto)
																		.addGap(18)
																		.addComponent(
																				jTCodProduto,
																				GroupLayout.PREFERRED_SIZE,
																				109,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				jBBuscaProduto)))
										.addContainerGap()));
		gl_jPDadosProduto
				.setVerticalGroup(gl_jPDadosProduto
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jPDadosProduto
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jPDadosProduto
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jLCodProduto)
														.addComponent(
																jTCodProduto,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jBBuscaProduto))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jScrollPaneProduto,
												GroupLayout.DEFAULT_SIZE, 106,
												Short.MAX_VALUE)
										.addContainerGap()));
		jPDadosProduto.setLayout(gl_jPDadosProduto);

		jLCpf = new JLabel("CPF:");

		jTCpf = new JFormattedTextField();
		jTCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.MaskFormatter("###.###.###-##")));

		jBBuscarCliente = new JButton("Buscar");
		jBBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jfbuscacliente == null) {
					try {
						jfbuscacliente = new JFBuscaCliente(getInstance());
						jfbuscacliente.setVisible(true);
						dispose();
					} catch (SQLException | ParseException ex) {
						Logger.getLogger(JFProduto.class.getName()).log(
								Level.SEVERE, null, ex.getMessage());
						JOptionPane.showMessageDialog(null, ex);
					}

				} else {
					jfbuscacliente.setVisible(true);
					dispose();
					
				}
			}
		});
		jBBuscarCliente.setIcon(new ImageIcon(JFVenda.class
				.getResource("/projeto/vendas/images/1999_16x16.png")));

		jLNomeCliente = new JLabel("Nome Cliente:");

		jTNomeCliente = new JTextField();
		jTNomeCliente.setColumns(10);

		jLNomeMae = new JLabel("Nome M\u00E3e:");

		jTNomeMae = new JTextField();
		jTNomeMae.setColumns(10);

		jLRg = new JLabel("RG:");

		jTRg = new JTextField();
		jTRg.setColumns(10);

		jLDataNasc = new JLabel("Data Nasc:");

		jTDataNasc = new JFormattedTextField();

		jLNomePai = new JLabel("Nome Pai:");

		jTNomePai = new JTextField();
		jTNomePai.setColumns(10);

		jLTelefone = new JLabel("Telefone:");

		jTTelefone = new JTextField();
		jTTelefone.setColumns(10);

		jLSexo = new JLabel("Sexo:");

		jTSexo = new JTextField();
		jTSexo.setColumns(10);

		jLEstadoCivil = new JLabel("Estado Civil:");

		jTEstadoCivil = new JTextField();
		jTEstadoCivil.setColumns(10);

		jLEmail = new JLabel("Email:");

		jTEmail = new JTextField();
		jTEmail.setColumns(10);

		jLEndereco = new JLabel("Endere\u00E7o:");

		jTEndereco = new JTextField();
		jTEndereco.setColumns(10);

		jLBairro = new JLabel("Bairro:");

		jTBairro = new JTextField();
		jTBairro.setColumns(10);

		jLCep = new JLabel("Cep:");

		jLEstado = new JLabel("Estado:");

		jLCidade = new JLabel("Cidade:");

		jTCidade = new JTextField();
		jTCidade.setColumns(10);

		jTEstado = new JTextField();
		jTEstado.setColumns(10);
		
		jTCep = new JFormattedTextField();
		jTCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.MaskFormatter("##.###-###")));

		GroupLayout gl_jPDadosCliente = new GroupLayout(jPDadosCliente);
		gl_jPDadosCliente.setHorizontalGroup(
			gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPDadosCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPDadosCliente.createSequentialGroup()
							.addComponent(jLCpf)
							.addGap(62)
							.addComponent(jTCpf, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(jBBuscarCliente)
							.addGap(307))
						.addGroup(gl_jPDadosCliente.createSequentialGroup()
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jPDadosCliente.createSequentialGroup()
										.addComponent(jLNomeCliente)
										.addGap(18)
										.addComponent(jTNomeCliente, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
									.addGroup(gl_jPDadosCliente.createSequentialGroup()
										.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
											.addComponent(jLNomeMae)
											.addComponent(jLNomePai))
										.addGap(31)
										.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_jPDadosCliente.createSequentialGroup()
												.addComponent(jTSexo, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(jLEstadoCivil)
												.addGap(18)
												.addComponent(jTEstadoCivil, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
											.addComponent(jTNomeMae, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
											.addComponent(jTNomePai, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
											.addComponent(jTEndereco, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
											.addGroup(gl_jPDadosCliente.createSequentialGroup()
												.addComponent(jTCep, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(jLEstado)
												.addGap(18)
												.addComponent(jTEstado, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
									.addGroup(gl_jPDadosCliente.createSequentialGroup()
										.addComponent(jLSexo)
										.addGap(378))
									.addGroup(gl_jPDadosCliente.createSequentialGroup()
										.addComponent(jLEndereco)
										.addGap(375)))
								.addGroup(gl_jPDadosCliente.createSequentialGroup()
									.addComponent(jLCep)
									.addGap(419)))
							.addGap(18)
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
								.addComponent(jLDataNasc)
								.addComponent(jLRg)
								.addComponent(jLTelefone)
								.addComponent(jLEmail)
								.addComponent(jLBairro)
								.addComponent(jLCidade))
							.addGap(18)
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jTCidade)
								.addComponent(jTEmail)
								.addComponent(jTTelefone)
								.addComponent(jTRg)
								.addComponent(jTDataNasc, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(jTBairro))
							.addContainerGap())))
		);
		gl_jPDadosCliente.setVerticalGroup(
			gl_jPDadosCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPDadosCliente.createSequentialGroup()
					.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_jPDadosCliente.createSequentialGroup()
							.addComponent(jTRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jTDataNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLDataNasc))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jTTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPDadosCliente.createSequentialGroup()
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLCpf)
								.addComponent(jTCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jBBuscarCliente))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLNomeCliente)
								.addComponent(jTNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLRg))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jTNomeMae, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLNomeMae))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(jTNomePai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLNomePai)
								.addComponent(jLTelefone))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLSexo)
						.addComponent(jTSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLEstadoCivil)
						.addComponent(jTEstadoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jTEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLEndereco)
						.addComponent(jTEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLBairro)
						.addComponent(jTBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPDadosCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLCep)
						.addComponent(jLCidade)
						.addComponent(jTCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLEstado)
						.addComponent(jTEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jTCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPDadosCliente.setLayout(gl_jPDadosCliente);
		jPVenda.setLayout(gl_jPVenda);
		jPContentVenda.setLayout(gl_jPContentVenda);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void desabilitaDados() {
		jTCpf.setEnabled(false);
		jTNomeCliente.setEnabled(false);
		jTRg.setEnabled(false);
		jTNomeMae.setEnabled(false);
		jTDataNasc.setEnabled(false);
		jTNomePai.setEnabled(false);
		jTTelefone.setEnabled(false);
		jTSexo.setEnabled(false);
		jTEstadoCivil.setEnabled(false);
		jTEmail.setEnabled(false);
		jTEndereco.setEnabled(false);
		jTBairro.setEnabled(false);
		jTEstado.setEnabled(false);
		jTCidade.setEnabled(false);
		jTCodProduto.setEnabled(false);
		jTCep.setEnabled(false);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFVenda frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
