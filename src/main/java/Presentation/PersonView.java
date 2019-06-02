package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.UserBLL;
import Model.Entities.Car;
import Model.Entities.Person;

public class PersonView extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField addrField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField userField;
	public JComboBox carsComboBox;
	
	UserBLL uBLL = new UserBLL();
	Person person;

	
	void setData(String user, String pass)
	{

		person = uBLL.getPerson(user,pass);
		
		nameField.setText(person.getName());
		addrField.setText(person.getAddress());
		phoneField.setText(person.getPhone());
		emailField.setText(person.getEmail());
		userField.setText(person.getUser());
		
		int id = person.getPersonID();
		
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<String> ls = new ArrayList<String>(); 
		
		cars = uBLL.getCars(person);
		
		for(int i = 0; i < cars.size(); i++)
		{
			ls.add(cars.get(i).getModel());
		}
		
		carsComboBox.setModel(new DefaultComboBoxModel(ls.toArray()));
	}
	
	public PersonView() {
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
				EditData editData = new EditData(person);
				editData.setData();
				editData.setVisible(true);
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
				AddCar addCar = new AddCar(person);
				addCar.setVisible(true);
			}
		});
		
		JButton btnBookSpace = new JButton("Book Space");
		btnBookSpace.setBounds(109, 227, 118, 23);
		contentPane.add(btnBookSpace);
		btnBookSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				Car car = uBLL.getCarByName(String.valueOf(carsComboBox.getSelectedItem()));
				SelectParking selectParking = new SelectParking(person,car);
				selectParking.setVisible(true);
			}
		});
		
		nameField = new JTextField();
		nameField.setBounds(68, 12, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		nameField.setEditable(false);
		
		addrField = new JTextField();
		addrField.setBounds(68, 37, 86, 20);
		contentPane.add(addrField);
		addrField.setColumns(10);
		addrField.setEditable(false);
		
		phoneField = new JTextField();
		phoneField.setBounds(68, 64, 86, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		phoneField.setEditable(false);
		
		emailField = new JTextField();
		emailField.setBounds(68, 89, 86, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		emailField.setEditable(false);
		
		userField = new JTextField();
		userField.setBounds(68, 114, 86, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		userField.setEditable(false);
		
		carsComboBox = new JComboBox();
		carsComboBox.setBounds(335, 117, 89, 22);
		contentPane.add(carsComboBox);
		
	}
}
