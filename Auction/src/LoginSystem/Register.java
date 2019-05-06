package LoginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Register {

	private JFrame AccountRegistration;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.AccountRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AccountRegistration = new JFrame();
		AccountRegistration.setBounds(100, 100, 400, 500);
		AccountRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AccountRegistration.getContentPane().setLayout(null);
		
		JLabel lblAccountRegistration = new JLabel("Account Registration");
		lblAccountRegistration.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAccountRegistration.setBounds(57, 11, 282, 54);
		AccountRegistration.getContentPane().add(lblAccountRegistration);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(57, 122, 76, 19);
		AccountRegistration.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(57, 178, 85, 19);
		AccountRegistration.getContentPane().add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(57, 239, 85, 19);
		AccountRegistration.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(66, 303, 76, 19);
		AccountRegistration.getContentPane().add(lblPassword);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(146, 123, 142, 20);
		AccountRegistration.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(146, 179, 142, 20);
		AccountRegistration.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(146, 240, 142, 20);
		AccountRegistration.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(146, 304, 142, 21);
		AccountRegistration.getContentPane().add(txtPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = txtFirstName.getText();
				String lastName = txtLastName.getText();
				String username = txtUsername.getText();
				String password = txtPassword.getText();

				File log = new File("LoginCredentials.txt");
				
				 if(log.exists()==false)
				    {
				            try {
								log.createNewFile();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				    }
				    PrintWriter out1 = null;
					try {
						out1 = new PrintWriter(new FileWriter(log, true));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    //append is used to insert into the end of a file without affecting any other data in it
				    //I have no idea why but putting it all on one line with /n doesn't work so I'm using system.getproperty but I 
				    //have no idea how that works, someone on stack overflow just said it would
				    out1.append(username);
				    out1.append(System.getProperty("line.separator"));
				    out1.append(password);
				    out1.append(System.getProperty("line.separator"));
				    out1.append(System.getProperty("line.separator"));
				    out1.close();
		        	JOptionPane.showMessageDialog(null, "Account Registration Successful", 
		        			"Account created", 
		        			JOptionPane.INFORMATION_MESSAGE);

				    AccountRegistration.dispose();


			}
		});
		btnRegister.setBounds(146, 392, 89, 23);
		AccountRegistration.getContentPane().add(btnRegister);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}