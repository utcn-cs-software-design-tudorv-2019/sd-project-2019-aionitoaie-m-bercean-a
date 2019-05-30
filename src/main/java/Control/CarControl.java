package Control;

import java.util.List;
import Model.Entities.Car;
import Model.Repositories.CarCRUD;

public class CarControl 
{
	private CarCRUD cCRUD = new CarCRUD();
	
	public void register(Car c)
	{
		cCRUD.create(c);
	}
	
	public List<Car> getAll()
	{
		return cCRUD.selectAll();
	}
}
