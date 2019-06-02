package Presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.UserBLL;
import Model.Entities.Car;
import Model.Entities.Person;
import Model.Entities.Plot;
import Model.Entities.PlotDetail;
import Model.Repositories.PlotDetailCRUD;

public class PlotsView extends JFrame {

	private JPanel contentPane;
	Person person;
	Car car;
	Plot finalPlot;
	PlotDetailCRUD plotDetailCRUD = new PlotDetailCRUD();
	UserBLL uBLL = new UserBLL();
	ArrayList<Plot> allPlots;
	PlotDetail finalPlotDetail;
	JButton[] pl;
	
	boolean selected = false;

	
	public void checkAvailablePlots(ArrayList<Plot> plots,PlotDetail plotDetail)
	{	
		allPlots = plots;
		Collections.sort(allPlots);
		//sort plots by number
		
		finalPlotDetail = plotDetail;
		
		pl = new JButton[plots.size()];
		
		for(int ii = 0; ii < allPlots.size(); ii++)
		{
			Plot p = allPlots.get(ii);
			
			ArrayList<PlotDetail> plotsDetails = uBLL.getPlotPlotsDetails(p);
			
			boolean available = true;
			
			//check if plot[ii] is available
			for(int i = 0; i < plotsDetails.size(); i++)
			{
				PlotDetail tempDetails = plotsDetails.get(i);
				PlotDetail testDetails = plotDetail;

				if(plotDetail.getDate() == plotsDetails.get(i).getDate())
				{
					//daca au aceeasi zi verifica datele
					if(tempDetails.getStartHour() <= testDetails.getStartHour() && testDetails.getStartHour() <= tempDetails.getEndHour())
					{
						available = false;
						//cannot make appointment
						break;
					}
					
					else if(tempDetails.getStartHour() <= testDetails.getEndHour() && testDetails.getEndHour() <= tempDetails.getEndHour())
					{
						available = false;
						//cannot make appointment
						break;
					}
					
					else if(testDetails.getStartHour() <= tempDetails.getStartHour() && tempDetails.getEndHour() <= testDetails.getEndHour())
					{
						available = false;
						//cannot make appointment
						break;
					}
				}
				
			}
			
			if(available)
			{
				//make it green
				pl[ii] = new JButton("plot"+(ii + 1));
				pl[ii].setBackground(Color.GREEN);
				contentPane.add(pl[ii]);
				pl[ii].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						int plotId = Integer.parseInt(e.getActionCommand().substring(4, 5));
						
						if(!selected)
						{
						pl[plotId - 1].setBackground(Color.yellow);
						finalPlot = allPlots.get(plotId-1);
						selected = !selected;
						}
						
						else
						{
							System.out.println("Already selected a plot");
							setVisible(false);
							PlotsView plotsView = new PlotsView(person,car);
							plotsView.checkAvailablePlots(allPlots,finalPlotDetail);
							plotsView.setVisible(true);
						}
					}
				});
				
			}
			
			else
			{
				pl[ii] = new JButton("plot");
				pl[ii].setBackground(Color.RED);
				pl[ii].setEnabled(false);
				contentPane.add(pl[ii]);
			}
			
		}
	}
	
	public void saveBooking()
	{
		
		finalPlotDetail.setPlot(finalPlot);
		finalPlotDetail.setCarName(car.getModel());

		plotDetailCRUD.create(finalPlotDetail);
		System.out.println("Booking confirmed for car " + car.getModel()
		+ " for (date, start, end) " + finalPlotDetail.getDate() + finalPlotDetail.getStartHour()
		+ finalPlotDetail.getEndHour());
	}

	public PlotsView(Person p, Car c) {
		
		person = p;
		car = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		
		JButton btnBookPlot = new JButton("BookPlot");
		contentPane.add(btnBookPlot);
		btnBookPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				saveBooking();
				setVisible(false);
				PersonView personView = new PersonView();
				personView.setData(person.getUser(), person.getPass());
				personView.setVisible(true);
			}
		});
	}

}
