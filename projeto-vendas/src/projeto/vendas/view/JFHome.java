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

public class JFHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2285480087524685085L;
	private JPanel jPHome;
	private JFCustomer jfcustomer;
	private JFProduto jfproduto;
	private JMenuBar jMenuHome;
	private JMenu jMenuArquivo;
	private JMenu jMenuCadastro;
	private JMenuItem jMenuItemSair;
	private JMenuItem jMenuItemCliente;
	private JMenuItem jMenuItemProduto;
	private JMenuItem jMenuItemVenda;
	private JFLogin jflogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFHome frame = new JFHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFHome() {
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
			public void actionPerformed(ActionEvent arg0) {
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
		jMenuItemVenda.setIcon(new ImageIcon(JFHome.class
				.getResource("/projeto/vendas/images/7146_25X25.png")));
		jMenuCadastro.add(jMenuItemVenda);
		jPHome = new JPanel();
		jPHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPHome.setLayout(new BorderLayout(0, 0));
		setContentPane(jPHome);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}
