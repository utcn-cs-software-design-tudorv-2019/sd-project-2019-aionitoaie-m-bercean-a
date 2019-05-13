import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import Model.Entities.Car;
import Model.Entities.Person;
import Model.Repositories.CarCRUD;
import Model.Repositories.PersonCRUD;
 
public class Runner {
	
	PersonCRUD personCRUD = new PersonCRUD();
	CarCRUD carCRUD = new CarCRUD();	
     
    @Test
    public void crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
         
        create();
        //read(session);
         
        //update(session);
        //read(session);
         
        //delete(session);
        //read(session);
         
        session.close();
    }
    
    private void create() {
        
    	Person p1 = new Person("str1","ion","123","email1","qwe","qwe");
    	Person p2 = new Person("str2","andrei","1234","email2","asd","asd");
    	
    	personCRUD.create(p1);
    	personCRUD.create(p2);
    	
    	Car c1 = new Car("mondeo",2012);
    	c1.setPerson(p1);
    	Car c2 = new Car("lambo",2011);
    	c2.setPerson(p1);
    	
    	
    	carCRUD.create(c1);
    	carCRUD.create(c2);
    	
    	
    	
    }
    
    //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
     
    private void delete(Session session) {
        System.out.println("Deleting mondeo record...");
        //Car mondeo = (Car) session.get(Car.class, "mondeo");
         
        session.beginTransaction();
        //session.delete(mondeo);
        session.getTransaction().commit();
    }
     
    private void update(Session session) {
        System.out.println("Updating mustang price...");
        //Car mustang = (Car) session.get(Car.class, "mustang");
        //mustang.setModel("mustang");
        //mustang.setPrice("£35,250.00");
         
        session.beginTransaction();
        //session.saveOrUpdate(mustang);
        session.getTransaction().commit();
    }
 
     
    private void read(Session session) {
        Query q = session.createQuery("select _car from Car _car");
         
        //List<Car> cars = q.list();
         
        System.out.println("Reading car records...");
        System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
        //for (Car c : cars) {
        //    System.out.printf("%-30.30s  %-30.30s%n", c.getModel(), c.getPrice());
        //}
    }
}