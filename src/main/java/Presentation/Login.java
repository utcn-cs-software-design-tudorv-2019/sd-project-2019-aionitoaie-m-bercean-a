package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.PersonControl;
import Model.Entities.Person;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private PersonControl pc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton adminLogInButton = new JButton("Log as admin");
		adminLogInButton.setBounds(10, 227, 110, 23);
		contentPane.add(adminLogInButton);
		adminLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new AdminLogin().setVisible(true);
			}
		});
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(167, 227, 89, 23);
		contentPane.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Person user = new Person();
				/*List<Person> pList = pc.getAll();
				for(Person p : pList)
				{
					if(p.getName() == usernameField.getText() && p.getPass() == passwordField.getText()) 
					{
						user = p;
						break;
					}
				}*/
				
				if("test" == usernameField.getText() && "test" == passwordField.getText()) 
				{
					user = new Person("1","2","3", "4", "5","6");
					user.setPass("none");
					user.setPersonID(-1);
				}
				setVisible(false);
				new PersonView(user).setVisible(true);
			}
		});
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(318, 227, 89, 23);
		contentPane.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new Register().setVisible(true);
			}
		});
		
		usernameField = new JTextField();
		usernameField.setBounds(170, 90, 86, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(170, 158, 86, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(184, 133, 61, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(184, 61, 66, 14);
		contentPane.add(lblNewLabel_1);
	}
}
