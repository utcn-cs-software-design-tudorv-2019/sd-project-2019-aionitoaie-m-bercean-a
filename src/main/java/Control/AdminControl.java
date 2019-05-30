package Control;

import java.util.List;

import Model.Entities.Admin;
import Model.Repositories.AdminCRUD;

public class AdminControl
{
	private AdminCRUD aCRUD = new AdminCRUD();
	
	public List<Admin> getAll()
	{
		return aCRUD.selectAll();
	}
}
