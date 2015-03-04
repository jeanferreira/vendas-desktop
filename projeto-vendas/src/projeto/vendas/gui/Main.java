package projeto.vendas.gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

import projeto.vendas.view.JFLogin;

public class Main extends SingleFrameApplication {

	private static JFLogin jlogin;

	@Override
	protected void startup() {
		if (jlogin == null) {
			try {
				jlogin = new JFLogin();
				jlogin.setVisible(true);
			} catch (SQLException ex) {
				Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE,
						null, ex.getMessage());
				JOptionPane.showMessageDialog(null, ex);
			}

		} else {
			jlogin.setVisible(true);
		}

	}

	public static Main getApplication() {
		return Application.getInstance(Main.class);
	}

	@Override
	protected void configureWindow(java.awt.Window root) {
	}

	public static void main(String[] args) {

		launch(Main.class, args);

	}

}
