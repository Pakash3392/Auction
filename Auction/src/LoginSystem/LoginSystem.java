package LoginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import AuctionHome.AuctionHome;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException; //?
import java.util.Scanner;

public class LoginSystem {

	private JFrame LoginSystem;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					window.LoginSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LoginSystem = new JFrame();
		LoginSystem.setBounds(200, 200, 500, 300);
		LoginSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginSystem.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogin.setBounds(193, 11, 103, 45);
		LoginSystem.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(72, 94, 72, 32);
		LoginSystem.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(82, 145, 82, 32);
		LoginSystem.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(154, 102, 200, 20);
		LoginSystem.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(154, 153, 200, 20);
		LoginSystem.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				int verification = 2;
				int verifyOne = 0;
				int verifyTwo = 0;
				int verifyThree;
				
				 File text = new File("C:/Users/Computer/git/repository/Auction/LoginCredentials.txt");
			      
			        //Creating Scanner instance to read File in Java
				    //eclipse automatically added this whole try{} thing, and it won't work without it?
			        Scanner scnr = null;
					try {
						scnr = new Scanner(text);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
					
			      while (verification == 2) {
			    	  
		
			    	  
			        //Reading each line of file using Scanner class
			        while(scnr.hasNextLine()){
			            String line = scnr.nextLine();
			            
			            if (username.equals(line))
			            {
			            	verifyOne++;
			            }
			            
			            if (password.equals(line))
			            {
			            	verifyTwo++;
			            }   
			        }
			        
			        verifyThree = (verifyOne + verifyTwo);
			        
			        if (verifyThree == verification) {
					    LoginSystem.dispose();
			        	AuctionHome.main(null);
			        	break;
			        }
			        
			        else 
			        {
			        	JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
			        	txtUsername.setText(null);
			        	txtPassword.setText(null);
			        	break;
			        }

			        

			      }
			      
			      
			}
		});
		btnLogin.setBounds(154, 207, 89, 23);
		LoginSystem.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
	        	Register.main(null);

			}
		});
		btnRegister.setBounds(265, 207, 89, 23);
		LoginSystem.getContentPane().add(btnRegister);
	}
}
