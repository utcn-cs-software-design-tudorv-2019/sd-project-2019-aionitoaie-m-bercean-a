package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AddCar extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField yearField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCar frame = new AddCar();
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
	public AddCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(168, 34, 86, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		yearField = new JTextField();
		yearField.setBounds(168, 97, 86, 20);
		contentPane.add(yearField);
		yearField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Model");
		lblNewLabel.setBounds(85, 37, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Year");
		lblNewLabel_1.setBounds(85, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRegister = new JButton("Register ");
		btnRegister.setBounds(165, 185, 89, 23);
		contentPane.add(btnRegister);
	}

}
