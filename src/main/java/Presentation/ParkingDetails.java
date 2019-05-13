package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ParkingDetails extends JFrame {

	private JPanel contentPane;
	private JTextField dateField;
	private JTextField startField;
	private JTextField durationField;


	/*
	 * TODO
	 * Data = 1-31 (ziua)
	 * Start = ora start 6-20
	 * No of Hours = durata de parcare
	 * 
	 * 6 < Start < 20 && 6 < Start + No of Hours < 20 
	 * 
	 * + verificare ca toate sa fie int nu string
	 * 
	 */
	public ParkingDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(82, 31, 46, 14);
		contentPane.add(lblDate);
		
		dateField = new JTextField();
		dateField.setBounds(128, 28, 86, 20);
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(40, 115, 46, 14);
		contentPane.add(lblStart);
		
		startField = new JTextField();
		startField.setBounds(82, 112, 86, 20);
		contentPane.add(startField);
		startField.setColumns(10);
		
		JLabel lblNoOfHours = new JLabel("No of Hours");
		lblNoOfHours.setBounds(210, 115, 70, 14);
		contentPane.add(lblNoOfHours);
		
		durationField = new JTextField();
		durationField.setBounds(291, 112, 86, 20);
		contentPane.add(durationField);
		durationField.setColumns(10);
		
		JButton btnSelectSlot = new JButton("Select Slot");
		btnSelectSlot.setBounds(163, 201, 89, 23);
		contentPane.add(btnSelectSlot);
	}

}
