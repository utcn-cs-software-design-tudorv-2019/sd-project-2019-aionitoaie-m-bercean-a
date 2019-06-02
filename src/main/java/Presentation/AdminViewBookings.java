package Presentation;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Control.AdminBLL;
import Model.Entities.PlotDetail;

public class AdminViewBookings extends JFrame {

	private JPanel contentPane;
	private JTable table;
	AdminBLL adminBLL = new AdminBLL();
	ArrayList<PlotDetail> allPlotDetails;

	
	public void populateTable()
	{
		allPlotDetails = adminBLL.getAllPlotDetails();
		
		String[] colNames = {"plotID","StartHour","EndHour","Date","CarName"};
		
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		
		model.setColumnIdentifiers(colNames);
		
		for (PlotDetail p : allPlotDetails)
		{
			Object[] o = new Object[5];
			o[0] = p.getPlot().getPlotId();
			o[1] = p.getStartHour();
			o[2] = p.getEndHour();
			o[3] = p.getDate();
			o[4] = p.getCarName();
				
			model.addRow(o);
		}

	}

	public AdminViewBookings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 63, 599, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
	}

}
