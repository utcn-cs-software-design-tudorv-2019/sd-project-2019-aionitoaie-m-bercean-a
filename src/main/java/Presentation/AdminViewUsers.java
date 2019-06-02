package Presentation;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Control.AdminBLL;
import Model.Entities.Person;

public class AdminViewUsers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	AdminBLL adminBLL = new AdminBLL();
	ArrayList<Person> allPersons;

	
	public void populateTable()
	{
		allPersons = adminBLL.getAllPersons();
		
		String[] colNames = {"user","pass","name","address","email","phone"};
		
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		
		model.setColumnIdentifiers(colNames);
		
		for (Person p : allPersons)
		{
			Object[] o = new Object[6];
			o[0] = p.getUser();
			o[1] = p.getPass();
			o[2] = p.getName();
			o[3] = p.getAddress();
			o[4] = p.getEmail();
			o[5] = p.getPhone();
				
			model.addRow(o);
		}

	}

	public AdminViewUsers() {
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
