import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import Model.Entities.Admin;
import Model.Entities.Car;
import Model.Entities.Parking;
import Model.Entities.Person;
import Model.Entities.Plot;
import Model.Entities.PlotDetail;
import Model.Repositories.AdminCRUD;
import Model.Repositories.CarCRUD;
import Model.Repositories.ParkingCRUD;
import Model.Repositories.PersonCRUD;
import Model.Repositories.PlotCRUD;
import Model.Repositories.PlotDetailCRUD;
 
public class Runner {
	
	PersonCRUD personCRUD = new PersonCRUD();
	CarCRUD carCRUD = new CarCRUD();
	ParkingCRUD parkCRUD = new ParkingCRUD();
	PlotCRUD plotCRUD = new PlotCRUD();
	AdminCRUD adminCRUD = new AdminCRUD();
	PlotDetailCRUD plotDetailCRUD = new PlotDetailCRUD();
     
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
    	
    	/*
    	 * --Creation Flow--
    	 * 
    	 * Create Person
    	 * Create Parkings
    	 * 
    	 * Create Car
    	 * Assign Owner to a Car
    	 * 
    	 * Create Admin
    	 * Assign a Parking to an Admin
    	 * 
    	 * Create Plot
    	 * Assign a Parking to a Plot
    	 * 
    	 * 
    	 * Create PlotDetail
    	 * Assign PlotDetail to Plot (reservation)
    	 * ???
    	 * 
    	 * Profit
    	 * 
    	 * 
    	 */
        
    	/*
    	 * Creating Persons
    	 */
    	
    	Person p1 = new Person("str1","ion","123","email1","qwe","qwe");
    	Person p2 = new Person("str2","andrei","1234","email2","asd","asd");
    	Person p3 = new Person("str3","vasile","12345","email3","zxc","zxc");
    	
    	personCRUD.create(p1);
    	personCRUD.create(p2);
    	personCRUD.create(p3);
    	
    	/*
    	 * Creating Parkings
    	 */
    	
    	Parking park1 = new Parking();
    	Parking park2 = new Parking();
    	
    	parkCRUD.create(park1);
    	parkCRUD.create(park2);
    	
    	/*
    	 * Creating Cars
    	 */
    	
    	Car c1 = new Car("mondeo",2012);
    	Car c2 = new Car("lambo",2011);
    	Car c3 = new Car("bmw",2014);
    	Car c4 = new Car("dacia",2001);
    	Car c5 = new Car("trabant",1989);
    	
    	//Assign owner to a car
    	c1.setPerson(p2);
    	c2.setPerson(p1);c4.setPerson(p1);
    	c3.setPerson(p3);c5.setPerson(p3);
    	
    	carCRUD.create(c1);
    	carCRUD.create(c2);
    	carCRUD.create(c3);
    	carCRUD.create(c4);
    	carCRUD.create(c5);
    	
    	/*
    	 * Creating Admins
    	 */

    	Admin a1 = new Admin ("admin1","admin","admin");
    	Admin a2 = new Admin("admin2","adminn","adminn");
    	
    	//Assign parking to admin
    	a1.setParking(park2);
    	park2.setAdminName(a1.getName());
    	a2.setParking(park1);
    	park1.setAdminName(a2.getName());
    	
    	adminCRUD.create(a1);
    	adminCRUD.create(a2);
    	
    	/*
    	 * Creating Plots
    	 */
    	

       	Plot pl1 = new Plot(100);
    	Plot pl2 = new Plot(50);
    	Plot pl3 = new Plot(100);
    	Plot pl4 = new Plot(100);
    	Plot pl5 = new Plot(50);
    	Plot pl6 = new Plot(50);
    	Plot pl7 = new Plot(100);
    	Plot pl8 = new Plot(50);
    	Plot pl9 = new Plot(100);  	
    	
    	//Assign parking to plot
    	pl1.setParking(park1);
    	pl3.setParking(park1);
    	pl6.setParking(park1);
    	pl8.setParking(park1);
    	pl9.setParking(park1);
    	
    	pl2.setParking(park2);
    	pl4.setParking(park2);
    	pl5.setParking(park2);
    	pl7.setParking(park2);
    	
    	
    	plotCRUD.create(pl1);
    	plotCRUD.create(pl2);
    	plotCRUD.create(pl3);
    	plotCRUD.create(pl4);
    	plotCRUD.create(pl5);
    	plotCRUD.create(pl6);
    	plotCRUD.create(pl7);
    	plotCRUD.create(pl8);
    	plotCRUD.create(pl9);
    	
    	
    	/*
    	 * Create some reservations (PlotDetails)
    	 * 
    	 */
    	
    	//public PlotDetail(int date, int start, int end, boolean state)
    	
    	PlotDetail pd1 = new PlotDetail(5,8,8+3,true);
    	PlotDetail pd2 = new PlotDetail(6,8,8+3,true);
    	PlotDetail pd3 = new PlotDetail(7,8,8+3,true);
    	PlotDetail pd4 = new PlotDetail(8,8,8+3,true);
    	PlotDetail pd5 = new PlotDetail(9,8,8+3,true);
    	PlotDetail pd6 = new PlotDetail(10,8,8+3,true);
    	PlotDetail pd7 = new PlotDetail(11,8,8+3,true);
    	PlotDetail pd8 = new PlotDetail(12,8,8+3,true);
    	
    	//assign reservation to a plot
    	pd1.setPlot(pl1);
    	pd2.setPlot(pl1);
    	pd3.setPlot(pl3);
    	pd4.setPlot(pl3);
    	pd5.setPlot(pl7);
    	pd6.setPlot(pl8);
    	pd7.setPlot(pl8);
    	pd8.setPlot(pl8);
    	
    	
    	//crud them
    	plotDetailCRUD.create(pd1);
    	plotDetailCRUD.create(pd2);
    	plotDetailCRUD.create(pd3);
    	plotDetailCRUD.create(pd4);
    	plotDetailCRUD.create(pd5);
    	plotDetailCRUD.create(pd6);
    	plotDetailCRUD.create(pd7);
    	plotDetailCRUD.create(pd8);
   
    	
    	// End Flow
    	
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