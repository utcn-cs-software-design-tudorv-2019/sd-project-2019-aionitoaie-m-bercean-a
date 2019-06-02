package Control;

import java.util.ArrayList;

import Model.Entities.Person;
import Model.Entities.PlotDetail;
import Model.Services.AdminServices;

public class AdminBLL {
	
	AdminServices adminServices = new AdminServices();

	public ArrayList<Person> getAllPersons()
	{
		return adminServices.getAllPersons();
	}
	
	public ArrayList<PlotDetail> getAllPlotDetails()
	{
		return adminServices.getAllPlotDetails();
	}
	
	public boolean checkAdminCredentials(String user, String pass)
	{
		return adminServices.checkAdminCredentials(user,pass);
	}
	
}
