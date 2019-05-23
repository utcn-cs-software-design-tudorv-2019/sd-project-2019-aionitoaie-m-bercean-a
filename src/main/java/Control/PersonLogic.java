package Control;

import Model.Entities.Person;
import Model.Repositories.PersonCRUD;

public class PersonLogic {

	private PersonCRUD pers;
	public void updateInfo(Person person) 
	{
		Person p = pers.read(person.getPersonID());
		person.setPass(p.getPass());
		pers.update(person);
	}
}