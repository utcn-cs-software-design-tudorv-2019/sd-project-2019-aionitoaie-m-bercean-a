package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {

	private JPanel contentPane;

	
	public AdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.setBounds(284, 67, 110, 23);
		contentPane.add(btnViewUsers);
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				//TODO
			}
		});
		
		JButton btnViewBookings = new JButton("View Bookings");
		btnViewBookings.setBounds(10, 135, 145, 23);
		contentPane.add(btnViewBookings);
		btnViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				//TODO
			}
		});
		
		JButton registerButton = new JButton("Register Person");
		registerButton.setBounds(10, 67, 145, 23);
		contentPane.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new Register().setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Hello Admin");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(163, 11, 145, 43);
		contentPane.add(lblNewLabel_1);
	}
}
