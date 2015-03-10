package projeto.vendas.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPasswordField;

import projeto.vendas.dao.UserDAO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class JFLogin extends JFrame {
	
	private static JFLogin INSTANCIA_LOGIN;

	
	private static final long serialVersionUID = 1L;
	private JPanel jPLogin;
	private JTextField jTUsuario;
	private JPanel jPDados;
	private JLabel jLUsuario;
	private JLabel jLSenha;
	private JPasswordField JPassSenha;
	private JButton jBEntrar;
	private final UserDAO usDAO;
	private JFHome jfhome;
	private static JFLogin jflogin;
	
	

	public static synchronized JFLogin getInstance() throws SQLException {
		if (INSTANCIA_LOGIN == null) {
			INSTANCIA_LOGIN = new JFLogin();
		}
		return jflogin;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFLogin frame = getInstance();
					frame.setVisible(true);
				} catch (Exception ex) {
					Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                    JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JFLogin() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFLogin.class.getResource("/projeto/vendas/images/cer_btn12.png")));
		
		this.usDAO = new UserDAO();
		initComponents();
		
		jBEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conectar();
				} catch (SQLException ex) {
					Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex.getMessage());
		            JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		jBEntrar.setBounds(10, 107, 223, 23);
		jPDados.add(jBEntrar);
		
		
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 397);
		jPLogin = new JPanel();
		jPLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPLogin);
		jPLogin.setLayout(null);

		jPDados = new JPanel();
		jPDados.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		jPDados.setBounds(183, 78, 255, 153);
		jPLogin.add(jPDados);
		jPDados.setLayout(null);

		jLUsuario = new JLabel("Usu\u00E1rio:");
		jLUsuario.setBounds(10, 36, 46, 14);
		jLUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		jLUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		jPDados.add(jLUsuario);

		jTUsuario = new JTextField();
		jTUsuario.setBounds(66, 33, 167, 20);
		jPDados.add(jTUsuario);
		jTUsuario.setColumns(10);

		jLSenha = new JLabel("Senha:");
		jLSenha.setBounds(10, 71, 46, 14);
		jPDados.add(jLSenha);
		
		JPassSenha = new JPasswordField();
		JPassSenha.setBounds(66, 68, 167, 20);
		jPDados.add(JPassSenha);

		jBEntrar = new JButton("Entrar");
		jBEntrar.setIcon(new ImageIcon(JFLogin.class.getResource("/projeto/vendas/images/icone_login.png")));
		
	}

	@SuppressWarnings("deprecation")
	public void conectar() throws SQLException {

		if (jTUsuario.getText().equals("") || JPassSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Campos usuario e/ou não podem ser vazios");
		} else {
			boolean logado = usDAO.connect(jTUsuario.getText(),
					JPassSenha.getText());

			if (logado == true) {
				if (jfhome == null) {
					jfhome = new JFHome();
					jfhome.setVisible(true);
					this.setVisible(false);
				}

				jfhome.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
				limpaDados();
			}
		}
	}
	
	public void limpaDados() {
		jTUsuario.setText("");
		JPassSenha.setText("");
	}	
	
}
