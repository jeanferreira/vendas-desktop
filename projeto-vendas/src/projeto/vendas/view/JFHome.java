package projeto.vendas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

public class JFHome extends JFrame {

	public static JFHome INSTANCIA_HOME;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2285480087524685085L;
	private JPanel jPHome;
	private JFCustomer jfcustomer;
	private JFProduto jfproduto;
	private JFVenda jfvenda;
	private JMenuBar jMenuHome;
	private JMenu jMenuArquivo;
	private JMenu jMenuCadastro;
	private JMenuItem jMenuItemSair;
	private JMenuItem jMenuItemCliente;
	private JMenuItem jMenuItemProduto;
	private JMenuItem jMenuItemVenda;
	private JFLogin jflogin;
	private JPanel jPDadosUsuario;
	private JLabel jLUsuario;
	private JLabel jLNomeUsuario;
	
	public static synchronized JFHome getInstance() throws SQLException {
		if (INSTANCIA_HOME == null) {
			INSTANCIA_HOME = new JFHome();
		}
		return INSTANCIA_HOME;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFHome frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JFHome() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFHome.class.getResource("/projeto/vendas/images/cer_btn12.png")));
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 615);

		jMenuHome = new JMenuBar();
		jMenuHome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setJMenuBar(jMenuHome);

		jMenuArquivo = new JMenu("Arquivo");
		jMenuArquivo.setIcon(new ImageIcon(JFHome.class
				.getResource("/projeto/vendas/images/arquivo35X32.png")));
		jMenuHome.add(jMenuArquivo);

		jMenuItemSair = new JMenuItem("Sair");
		jMenuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					JFrame jf = jflogin.getInstance();
					jf.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jMenuItemSair.setIcon(new ImageIcon(JFHome.class
				.getResource("/projeto/vendas/images/icone_sair.gif")));
		jMenuArquivo.add(jMenuItemSair);

		jMenuCadastro = new JMenu("Cadastros");
		jMenuCadastro.setIcon(new ImageIcon(JFHome.class
				.getResource("/projeto/vendas/images/cadastro35X32.png")));
		jMenuHome.add(jMenuCadastro);

		jMenuItemCliente = new JMenuItem("Cliente");
		jMenuItemCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				try {
					if (jfcustomer == null) {
						jfcustomer = new JFCustomer();
						jfcustomer.show();
					} else {
						jfcustomer.setVisible(true);
					}
				} catch (SQLException | ParseException ex) {
					Logger.getLogger(JFHome.class.getName()).log(Level.SEVERE,
							null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jMenuItemCliente.setIcon(new ImageIcon(JFHome.class
				.getResource("/projeto/vendas/images/iconeCliente25X25.png")));
		jMenuCadastro.add(jMenuItemCliente);

		jMenuItemProduto = new JMenuItem("Produto");
		jMenuItemProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (jfproduto == null) {
						jfproduto = new JFProduto();
						jfproduto.show();
					} else {
						jfproduto.setVisible(true);
					}
				} catch (SQLException ex) {
					Logger.getLogger(JFHome.class.getName()).log(Level.SEVERE,
							null, ex.getMessage());
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jMenuItemProduto
				.setIcon(new ImageIcon(
						JFHome.class
								.getResource("/projeto/vendas/images/icone_produtos25X25.png")));
		jMenuCadastro.add(jMenuItemProduto);

		jMenuItemVenda = new JMenuItem("Venda");
		jMenuItemVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jfvenda == null) {
					try {
						jfvenda = new JFVenda();
					} catch (ParseException ex) {
						Logger.getLogger(JFCustomer.class.getName()).log(
								Level.SEVERE, null, ex.getMessage());
						JOptionPane.showMessageDialog(null, ex);
					}
					jfvenda.show();
				}else {
					jfvenda.setVisible(true);
				}
			}
		});
		jMenuItemVenda.setIcon(new ImageIcon(JFHome.class
				.getResource("/projeto/vendas/images/7146_25X25.png")));
		jMenuCadastro.add(jMenuItemVenda);
		jPHome = new JPanel();
		jPHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPHome);
		
		jPDadosUsuario = new JPanel();
		jPDadosUsuario.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_jPHome = new GroupLayout(jPHome);
		gl_jPHome.setHorizontalGroup(
			gl_jPHome.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jPHome.createSequentialGroup()
					.addContainerGap(603, Short.MAX_VALUE)
					.addComponent(jPDadosUsuario, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_jPHome.setVerticalGroup(
			gl_jPHome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPHome.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPDadosUsuario, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(444, Short.MAX_VALUE))
		);
		
		jLUsuario = new JLabel("Usu\u00E1rio:");
		
		jLNomeUsuario = new JLabel("nome");
		GroupLayout gl_jPDadosUsuario = new GroupLayout(jPDadosUsuario);
		gl_jPDadosUsuario.setHorizontalGroup(
			gl_jPDadosUsuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPDadosUsuario.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLUsuario)
					.addGap(18)
					.addComponent(jLNomeUsuario)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_jPDadosUsuario.setVerticalGroup(
			gl_jPDadosUsuario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPDadosUsuario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPDadosUsuario.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLUsuario)
						.addComponent(jLNomeUsuario))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		jPDadosUsuario.setLayout(gl_jPDadosUsuario);
		jPHome.setLayout(gl_jPHome);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
}
