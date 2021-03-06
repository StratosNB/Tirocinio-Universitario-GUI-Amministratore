package admingui.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import admingui.view.LoginFrame;
import admingui.view.MainFrame;

public class LoginFrameController {

	private JFrame loginFrame;
	private LoginFrame paneLogin;

	private MainFrame mainFrame;

	// private UserDAO userDAO = new UserDAO();

	public LoginFrameController(LoginFrame loginFrame, MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginFrame = loginFrame.getMainFrame();
		this.paneLogin = loginFrame;
		loginFrame.addLoginListener(new LoginListener());
	}

	class LoginListener implements ActionListener {
		String id;
		String pswd;

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Login":

				id = paneLogin.getUserIDInput();
				pswd = paneLogin.getPasswordInput();

				loginFrame.dispose();
				JOptionPane.showMessageDialog(loginFrame, "          Login Successful");

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							mainFrame.getMainFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				/*
				 * if (paneLogin.isEmptyData()) {
				 * JOptionPane.showMessageDialog(null,
				 * "          No data inserted", "Login Error",
				 * JOptionPane.ERROR_MESSAGE); return; }
				 */

				/*
				 * if (userDAO.checkCredentials(id, pswd) == false) {
				 * JOptionPane.showMessageDialog(null,
				 * "     Incorrect id or password", "Login Error",
				 * JOptionPane.ERROR_MESSAGE);
				 * 
				 * } else { frame.dispose(); JOptionPane.showMessageDialog(null,
				 * "         Login Successful"); mainPane.setVisible(true); }
				 */
				break;

			case "Cancel":
				loginFrame.dispose();
				break;
			}

		}
	}

}
