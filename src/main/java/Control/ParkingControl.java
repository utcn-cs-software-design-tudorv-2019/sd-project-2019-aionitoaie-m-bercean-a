package Control;

import java.util.List;

import Model.Entities.Parking;
import Model.Repositories.ParkingCRUD;

public class ParkingControl 
{
	private ParkingCRUD pCRUD = new ParkingCRUD();
	
	public List<Parking> getAll()
	{
		return pCRUD.selectAll();
	}
}
