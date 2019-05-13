package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class PlotsView extends JFrame {

	private JPanel contentPane;


	public PlotsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		/*
		 * TODO
		 * 
		 * Nr max plots pentru Parking n cu un for() add all plots
		 * 
		 * btn.setBackground(Color.RED); -- plot ocupat
		 * btn.setBackground(Color.GREEM); -- plot liber
		 * 
		 * + un mesaj de FAIL/SUCCESS
		 * 
		 */
		
		JButton btnP = new JButton("p1");
		btnP.setBackground(Color.GREEN);
		contentPane.add(btnP);
		
		JButton btnP_1 = new JButton("p2");
		btnP_1.setBackground(Color.RED);
		contentPane.add(btnP_1);
		
		JButton btnBookPlot = new JButton("BookPlot");
		contentPane.add(btnBookPlot);
		btnBookPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new PersonView().setVisible(true);
			}
		});
	}

}
