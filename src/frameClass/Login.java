package frameClass;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HibernateManager.UserManager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static String username;
	static String password;
	Managerfirst managerfirst;
	Salesfirst salesfirst;
	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */

	

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
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
	 */
	public Login() throws SQLException {
		
		super("Login form");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(191, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(97, 72, 89, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(97, 115, 89, 14);
		contentPane.add(lblPassword);

		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 112, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		
		//Action for validating a user
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = textField.getText();
				password = textField_1.getText();

				UserManager OO = new UserManager();
				if (OO.validation_of_user(username, password).equals("NotExist")) {

					JOptionPane.showMessageDialog(contentPane, "Your username or pass is wrong");
				} else if (OO.validation_of_user(username, password).equals("Manager")){

					dispose();
					System.out.println(OO.validation_of_user(username, password));
					try{
					Managerfirst managerfirst = new Managerfirst ();
					managerfirst.setVisible(true);
					}
					catch (Exception e) {
						e.printStackTrace();
					}

				}
				
				 else if (OO.validation_of_user(username, password).equals("SalesOperator")){

						dispose();
						System.out.println(OO.validation_of_user(username, password));
						try{
							Salesfirst salesfirst = new Salesfirst ();
							salesfirst.setVisible(true);
						}
						catch (Exception e) {
							e.printStackTrace();
						}

					}

				

			}
		});

		btnNewButton.setBounds(160, 174, 89, 23);
		contentPane.add(btnNewButton);

	}
	

}
