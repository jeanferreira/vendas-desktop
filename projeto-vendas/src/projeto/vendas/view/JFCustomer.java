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
import projeto.vendas.model.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCustomer extends JFrame {
	
	private final CustomerDAO controlCus;
    List<Customer> lsCliente;
    Customer customer;
	DefaultTableModel tmCliente = new DefaultTableModel(null, new String[]{"CPF", "NOME", "EMAIL", "TEL", "ENDEREÇO", "CEP", "BAIRRO", "ESTADO", "CIDADE"}){
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
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	public JFCustomer() throws ParseException, SQLException {
		initComponents();
		this.controlCus = new CustomerDAO();
	}

	private void initComponents() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 489);
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
		jPBotoes.setBorder(new TitledBorder(null, "Bot\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPBotoes.setBounds(10, 11, 619, 92);
		jPCliente.add(jPBotoes);
		jPBotoes.setLayout(null);
		
		jBNovo = new JButton("Novo");
		jBNovo.setIcon(new ImageIcon(JFCustomer.class.getResource("/projeto/vendas/images/novo.png")));
		jBNovo.setBounds(10, 23, 106, 40);
		jPBotoes.add(jBNovo);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setIcon(new ImageIcon(JFCustomer.class.getResource("/projeto/vendas/images/1428_32x32.png")));
		jbSalvar.setBounds(126, 23, 106, 40);
		jPBotoes.add(jbSalvar);
		
		jBLimpar = new JButton("Limpar");
		jBLimpar.setIcon(new ImageIcon(JFCustomer.class.getResource("/projeto/vendas/images/Eraser-32.png")));
		jBLimpar.setBounds(503, 23, 106, 40);
		jPBotoes.add(jBLimpar);
		
		jPDadosCliente = new JPanel();
		jPDadosCliente.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jPDadosCliente.setBounds(10, 114, 619, 310);
		jPCliente.add(jPDadosCliente);
		jPDadosCliente.setLayout(null);
		
		jLCpf = new JLabel("CPF:");
		jLCpf.setBounds(10, 32, 28, 14);
		jPDadosCliente.add(jLCpf);
		
		jFormattedCpf = new JFormattedTextField();
		jFormattedCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		jFormattedCpf.setBounds(66, 29, 98, 20);
		jPDadosCliente.add(jFormattedCpf);
		
		jLNomeCliente = new JLabel("Nome Cliente:");
		jLNomeCliente.setBounds(185, 32, 67, 14);
		jPDadosCliente.add(jLNomeCliente);
		
		jTNomeCliente = new JTextField();
		jTNomeCliente.setBounds(262, 29, 347, 20);
		jPDadosCliente.add(jTNomeCliente);
		jTNomeCliente.setColumns(10);
		
		jLRg = new JLabel("RG:");
		jLRg.setBounds(10, 69, 28, 14);
		jPDadosCliente.add(jLRg);
		
		jTRg = new JTextField();
		jTRg.setBounds(66, 66, 98, 20);
		jPDadosCliente.add(jTRg);
		jTRg.setColumns(10);
		
		jLNomeMae = new JLabel("Nome M\u00E3e:");
		jLNomeMae.setBounds(185, 69, 67, 14);
		jPDadosCliente.add(jLNomeMae);
		
		jTNomeMae = new JTextField();
		jTNomeMae.setBounds(262, 66, 347, 20);
		jPDadosCliente.add(jTNomeMae);
		jTNomeMae.setColumns(10);

		jPListar = new JPanel();
		tabbedPaneCliente.addTab("Listar Cliente", null, jPListar, null);
		jPListar.setLayout(null);
		
		jBPesquisar = new JButton("Pesquisar");
		jBPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pesquisarCliente();
				} catch (SQLException ex) {
					Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex.getMessage());
		            JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBPesquisar.setIcon(new ImageIcon(JFCustomer.class.getResource("/projeto/vendas/images/1999_16x16.png")));
		jBPesquisar.setBounds(524, 11, 105, 23);
		jPListar.add(jBPesquisar);
		
		jTPesquisar = new JTextField();
		jTPesquisar.setBounds(10, 12, 504, 20);
		jPListar.add(jTPesquisar);
		jTPesquisar.setColumns(10);
		
		jScrollPaneListarCliente = new JScrollPane();
		jScrollPaneListarCliente.setBounds(10, 43, 619, 381);
		jPListar.add(jScrollPaneListarCliente);
		
		jTableCliente = new JTable();
		jTableCliente.setModel(tmCliente);
		jScrollPaneListarCliente.setViewportView(jTableCliente);
		

		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}
	
	public void pesquisarCliente() throws SQLException {
        lsCliente = controlCus.listarCliente("%" + jTPesquisar.getText().toUpperCase() + "%");
        mostrarCliente(lsCliente);
    }

    public void mostrarCliente(List<Customer> clientes) {

        while (tmCliente.getRowCount() > 0) {
            tmCliente.removeRow(0);
        }

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum resultado obtido");
        } else {
            String[] linha = new String[]{null, null, null, null, null, null, null, null, null};
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
