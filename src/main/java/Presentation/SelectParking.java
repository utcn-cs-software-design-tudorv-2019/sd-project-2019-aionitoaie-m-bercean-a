package Presentation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.UserBLL;
import Model.Entities.Car;
import Model.Entities.Parking;
import Model.Entities.Person;
import Model.Repositories.ParkingCRUD;

public class SelectParking extends JFrame {

	private JPanel contentPane;
	Person person;
	Car car;
	UserBLL uBLL = new UserBLL();
	ParkingCRUD parkingCRUD = new ParkingCRUD();
	

	public SelectParking(Person p,Car c) {
		person = p; 
		car = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 157);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		//TODO
		//butoane in functie de cate P sunt disponibile in tabela (max PK tabela Parking)
		
		JButton btnP1 = new JButton("P1");
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				//get all plots wait for details
				ParkingDetails parkingDetails = new ParkingDetails(person,car);
				Parking parking = parkingCRUD.read(1);
				parkingDetails.getPlots(parking);
				
				parkingDetails.setVisible(true);
				//new PlotsView().setVisible(true);
			}
		});
		
		JButton btnP2 = new JButton("P2");
		contentPane.add(btnP2);
		btnP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				
				ParkingDetails parkingDetails = new ParkingDetails(person,car);
				Parking parking = parkingCRUD.read(2);
				parkingDetails.getPlots(parking);
				
				parkingDetails.setVisible(true);
				//new PlotsView().setVisible(true);
			}
		});
	}

}
