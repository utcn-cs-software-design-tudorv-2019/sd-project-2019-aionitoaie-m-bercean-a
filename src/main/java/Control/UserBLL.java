package Control;

import java.util.ArrayList;

import Model.Entities.Car;
import Model.Entities.Parking;
import Model.Entities.Person;
import Model.Entities.Plot;
import Model.Entities.PlotDetail;
import Model.Services.UserServices;


public class UserBLL {
	
	UserServices userServices = new UserServices();
	
	public Person getPerson(String user, String pass)
	{
		return userServices.getData(user, pass);
	}
	
	public ArrayList<Car> getCars(Person p)
	{
		return userServices.getCarData(p);
	}

	public int getMaxParkingId()
	{
		return userServices.getMaxParkingId();
	}
	
	public ArrayList<Plot> getPlotsByParkingId(Parking parking)
	{
		return userServices.getPlotsByParkingId(parking);
	}
	
	public ArrayList<PlotDetail> getPlotPlotsDetails(Plot p)
	{
		return userServices.getPlotPlotsDetails(p);
	}
	
	public Car getCarByName(String name)
	{
		return userServices.getCarByName(name);
	}
	
	public boolean checkPlotDetails(PlotDetail plotDetail) {
		
		if(plotDetail.getEndHour() - plotDetail.getStartHour() > 5)
		{
			System.out.println("Too many hours max 5");
			return false;
		}
		
		if(plotDetail.getDate() <= 0 || plotDetail.getDate() > 31)
		{
			System.out.println("Day not available select between 1 - 31");
			return false;
		}
		
		if(plotDetail.getStartHour() < 6)
		{
			System.out.println("Program begins at 6 am");
			return false;
		}
		
		if(plotDetail.getEndHour() > 20)
		{
			System.out.println("Program ends at 20 pm");
			return false;
		}
		
		return true;
	}
	
}
