package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Entities.Person;
import Model.Repositories.PersonCRUD;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField addrField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField userField;
	private JTextField passField;
	PersonCRUD personCRUD = new PersonCRUD();


	public void saveNewUser()
	{
		Person p = new Person(
				addrField.getText(),
				nameField.getText(),
				phoneField.getText(),
				emailField.getText(),
				userField.getText(),
				passField.getText()
				);

		personCRUD.create(p);
	}
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(335, 11, 89, 23);
		contentPane.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				saveNewUser();
				setVisible(false);
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(10, 15, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setBounds(10, 40, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(10, 67, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 92, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblUser = new JLabel("user");
		lblUser.setBounds(10, 117, 46, 14);
		contentPane.add(lblUser);
		
		nameField = new JTextField();
		nameField.setBounds(68, 12, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		addrField = new JTextField();
		addrField.setBounds(68, 37, 86, 20);
		contentPane.add(addrField);
		addrField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(68, 64, 86, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(68, 89, 86, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		userField = new JTextField();
		userField.setBounds(68, 114, 86, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pass");
		lblNewLabel.setBounds(8, 146, 46, 14);
		contentPane.add(lblNewLabel);
		
		passField = new JTextField();
		passField.setBounds(68, 145, 86, 20);
		contentPane.add(passField);
		passField.setColumns(10);
	}

}
