package projeto.vendas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class JFHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2285480087524685085L;
	private JPanel jPHome;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		mnNewMenu.setIcon(new ImageIcon(JFHome.class.getResource("/projeto/vendas/images/arquivo35X32.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.setIcon(new ImageIcon(JFHome.class.getResource("/projeto/vendas/images/icone_sair.gif")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Cadastros");
		mnNewMenu_1.setIcon(new ImageIcon(JFHome.class.getResource("/projeto/vendas/images/cadastro35X32.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(JFHome.class.getResource("/projeto/vendas/images/iconeCliente25X25.png")));
		mnNewMenu_1.add(mntmCliente);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.setIcon(new ImageIcon(JFHome.class.getResource("/projeto/vendas/images/icone_produtos25X25.png")));
		mnNewMenu_1.add(mntmProduto);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Venda");
		mntmNewMenuItem_1.setIcon(new ImageIcon(JFHome.class.getResource("/projeto/vendas/images/7146_25X25.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		jPHome = new JPanel();
		jPHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPHome.setLayout(new BorderLayout(0, 0));
		setContentPane(jPHome);
		setLocationRelativeTo(null);
	}

}
