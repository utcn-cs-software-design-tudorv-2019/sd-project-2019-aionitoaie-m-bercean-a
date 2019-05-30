package Control;

import java.util.List;

import Model.Entities.Person;
import Model.Repositories.PersonCRUD;

public class PersonControl {
	
	private PersonCRUD pCRUD = new PersonCRUD();
	
	public List<Person> getAll()
	{
		return pCRUD.selectAll();
	}
	
	public Person getPerson(Person p)
	{
		return pCRUD.read(p.getPersonID());
	}
	
	public void edit(Person p)
	{
		pCRUD.update(p);
	}
	
	public void register(Person p)
	{
		pCRUD.create(p);
	}
	
}
