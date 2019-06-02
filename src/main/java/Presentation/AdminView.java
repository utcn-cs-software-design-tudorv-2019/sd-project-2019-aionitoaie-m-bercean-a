package Presentation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Control.AdminBLL;
import Model.Entities.Person;
import net.proteanit.sql.DbUtils;

public class AdminView extends JFrame {

	private JPanel contentPane;
	AdminBLL adminBLL = new AdminBLL();

	
	public boolean checkCredentials(String user, String pass)
	{
		
		if(adminBLL.checkAdminCredentials(user,pass))
		{
			return true;
		}
		
		return false;
	}
	
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
				//setVisible(false);
				AdminViewUsers adminViewUsers = new AdminViewUsers();
				adminViewUsers.populateTable();
				adminViewUsers.setVisible(true);
				adminViewUsers.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
			}
		});
		
		JButton btnViewBookings = new JButton("View Bookings");
		btnViewBookings.setBounds(10, 135, 145, 23);
		contentPane.add(btnViewBookings);
		btnViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//setVisible(false);
				AdminViewBookings adminViewBookings = new AdminViewBookings();
				adminViewBookings.populateTable();
				adminViewBookings.setVisible(true);
				adminViewBookings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		
		JLabel lblNewLabel_1 = new JLabel("\r\n" + 
				"Привет, товарищ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(163, 11, 145, 43);
		contentPane.add(lblNewLabel_1);
	}
}
