package Control;

import java.util.List;

import Model.Entities.PlotDetail;
import Model.Repositories.PlotDetailCRUD;

public class PlotDetailControl 
{
	private PlotDetailCRUD pCRUD = new PlotDetailCRUD();
	
	public List<PlotDetail> getAll()
	{
		return pCRUD.selectAll();
	}
}
