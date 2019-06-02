package Model.Repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Car;

public class CarCRUD implements MasterInterface<Car, Integer>{
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;

	public void create(Car obiect) {
		System.out.println("Creating new Car record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public Car read(Integer idObiect) {
		Car c;
		
		System.out.println("Reading Car record...");
		session = sessionFactory.openSession();

		c = (Car)session.get(Car.class, idObiect);
		
		session.close();
		
		return c;
	}

	public void update(Car obiect) {
		System.out.println("Updating Car...");
		session = sessionFactory.openSession();
		
		Car c = (Car) session.get(Car.class, obiect.getCarID() );
		
		c.setModel(obiect.getModel());
		c.setPerson(obiect.getPerson());
		c.setYear(obiect.getYear());
		
		
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public void delete(Integer idObiect) {
		System.out.println("Deleting Car record...");
		session = sessionFactory.openSession();
		
		Car c = (Car) session.get(Car.class, idObiect);
		
		session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
		
		session.close();
		
	}

}