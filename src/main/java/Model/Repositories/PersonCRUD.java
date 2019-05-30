package Model.Repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Parking;
import Model.Entities.Person;


public class PersonCRUD implements MasterInterface<Person, Integer>{
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;

	public void create(Person obiect) {
		System.out.println("Creating new person record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> selectAll(){
		session = sessionFactory.openSession();
		
		Query q = session.createQuery("SELECT * FROM Person");
		List<Person> a = q.list();
		return a;
	}
	
	public Person read(Integer idObiect) {
		Person p;
		
		System.out.println("Reading student record...");
		session = sessionFactory.openSession();

		p = (Person)session.get(Person.class, idObiect);
		
		session.close();
		
		return p;
	}

	public void update(Person obiect) {
		System.out.println("Updating student...");
		session = sessionFactory.openSession();
		
		Person p = (Person) session.get(Person.class, obiect.getPersonID());
		
		p.setAddress(obiect.getAddress());
		p.setEmail(obiect.getEmail());
		p.setName(obiect.getName());
		p.setPhone(obiect.getPhone());

		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public void delete(Integer idObiect) {
		System.out.println("Deleting person record...");
		session = sessionFactory.openSession();
		
		Person p = (Person) session.get(Person.class, idObiect);
		
		
		session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
		
		session.close();
		
	}

}
