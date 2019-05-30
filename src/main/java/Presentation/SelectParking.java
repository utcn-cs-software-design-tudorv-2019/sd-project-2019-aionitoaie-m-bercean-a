package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ParkingControl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import net.miginfocom.swing.MigLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JButton;

public class SelectParking extends JFrame {

	private JPanel contentPane;
	private ParkingControl pc = new ParkingControl();


	public SelectParking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 157);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		//TODO
		//butoane in functie de cate P sunt disponibile in tabela (max PK tabela Parking)
		
		JButton[] btnArray = new JButton[6];
		
		for(int i = 0; i < 6; i++)
		{
			btnArray[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					setVisible(false);
					new PlotsView().setVisible(true);
				}
			});
			btnArray[i].setText("P"+i);
			if(i < pc.getAll().size()) contentPane.add(btnArray[i]);
		}
		
		/*JButton btnP1 = new JButton("P1");
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new PlotsView().setVisible(true);
			}
		});
		
		JButton btnP1 = new JButton("P2");
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new PlotsView().setVisible(true);
			}
		});
		
		JButton btnP1 = new JButton("P3");
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new PlotsView().setVisible(true);
			}
		});
		
		JButton btnP1 = new JButton("P4");
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new PlotsView().setVisible(true);
			}
		});
		
		JButton btnP1 = new JButton("P5");
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new PlotsView().setVisible(true);
			}
		});
		
		JButton btnP1 = new JButton("P6");
		contentPane.add(btnP1);
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new PlotsView().setVisible(true);
			}
		});*/
	}

}
