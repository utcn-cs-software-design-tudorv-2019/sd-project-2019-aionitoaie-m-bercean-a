package Control;

import java.util.List;

import Model.Entities.Plot;
import Model.Repositories.PlotCRUD;

public class PlotControl 
{
	private PlotCRUD pCRUD = new PlotCRUD();
	
	public List<Plot> getAll()
	{
		return pCRUD.selectAll();
	}
}
