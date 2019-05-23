package Presentation;

import Model.Repositories.CarCRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PersonView extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField addrField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField userField;
	
	private Integer userID;
	
	private CarCRUD car;
	
	public PersonView( final Integer id) {
		
		userID = id;
		
		nameField.setEditable(false);
		addrField.setEditable(false);
		phoneField.setEditable(false);
		emailField.setEditable(false);
		userField.setEditable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(335, 11, 89, 23);
		contentPane.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new EditData(id).setVisible(true);
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
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.setBounds(10, 227, 89, 23);
		contentPane.add(btnAddCar);
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new AddCar().setVisible(true);
			}
		});
		
		JButton btnBookSpace = new JButton("Book Space");
		btnBookSpace.setBounds(109, 227, 118, 23);
		contentPane.add(btnBookSpace);
		btnBookSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new SelectParking().setVisible(true);
			}
		});
		
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
		
		JComboBox carsComboBox = new JComboBox();
		carsComboBox.setBounds(335, 117, 89, 22);
		contentPane.add(carsComboBox);
		List<String> ls = new ArrayList<String>();
		carsComboBox.setModel(new DefaultComboBoxModel(ls.toArray()));
	}
}
