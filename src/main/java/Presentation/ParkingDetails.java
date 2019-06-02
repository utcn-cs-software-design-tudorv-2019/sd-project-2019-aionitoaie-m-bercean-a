package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.UserBLL;
import Model.Entities.Car;
import Model.Entities.Parking;
import Model.Entities.Person;
import Model.Entities.Plot;
import Model.Entities.PlotDetail;

public class ParkingDetails extends JFrame {

	private JPanel contentPane;
	private JTextField dateField;
	private JTextField startField;
	private JTextField durationField;
	Person person;
	Car car;
	PlotDetail plotDetail;
	UserBLL uBLL = new UserBLL();
	ArrayList<Plot> plots ;

	public void getPlots(Parking parking)
	{
		plots = uBLL.getPlotsByParkingId(parking);
	}
	
	public void createPlotDetails()
	{
		int data = Integer.parseInt(dateField.getText());
		int start = Integer.parseInt(startField.getText());
		int end = start + Integer.parseInt(durationField.getText());
		
		plotDetail = new PlotDetail(data,start,end,true);//check if available
		
	}
	
	public ParkingDetails(Person p, Car c) {
		person = p;
		car = c;
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
		btnSelectSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				createPlotDetails();
				
				if(uBLL.checkPlotDetails(plotDetail)) {
					setVisible(false);
					PlotsView plotsView = new PlotsView(person,car);
					plotsView.checkAvailablePlots(plots,plotDetail);
					plotsView.setVisible(true);
				}

			}
		});
	}

}
