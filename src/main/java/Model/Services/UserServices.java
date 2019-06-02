package Model.Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import Model.Entities.Car;
import Model.Entities.Parking;
import Model.Entities.Person;
import Model.Entities.Plot;
import Model.Entities.PlotDetail;

public class UserServices {
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
	
	public Person getData(String user, String pass)
	{
		session = sessionFactory.openSession();
		
		System.out.println(user + "" + pass);
		
		Criteria criteria = session.createCriteria(Person.class)
				.add(Restrictions.eq("userP",user))
				.add(Restrictions.eq("passP", pass));
		
		Person p = (Person)criteria.uniqueResult();
		
		
		session.close();
		
		
		return p;
	}

	public ArrayList<Car> getCarData(Person p)
	{
		session = sessionFactory.openSession();
		
		int id = p.getPersonID();
		
		Criteria criteria = session.createCriteria(Car.class)
				.add(Restrictions.eq("person",p));
		
		List<Car> cars = criteria.list();
		
		session.close();
		
		return (ArrayList<Car>) cars;
	}

	public int getMaxParkingId()
	{
		session = sessionFactory.openSession();
		
		int id = (Integer) session.createQuery("select parkId from Parking where parkId =(select max(parkId) from Parking)").uniqueResult();
		
		//System.out.println("Id = " + id);
		
		session.close();

		return id;
	}
	
	public ArrayList<Plot> getPlotsByParkingId(Parking parking)
	{
		session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Plot.class)
				.add(Restrictions.eq("parking", parking));
		
		List<Plot> plots = criteria.list();
		
		session.close();

		return (ArrayList<Plot>) plots;
	}
	
	public ArrayList<PlotDetail> getPlotPlotsDetails(Plot p)
	{
		session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(PlotDetail.class)
				.add(Restrictions.eq("plot", p));
		
		List<PlotDetail> plotsDetails = criteria.list();
		
		session.close();
		
		return (ArrayList<PlotDetail>) plotsDetails;
	}
	
	public Car getCarByName(String name)
	{
		session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Car.class)
				.add(Restrictions.eq("model", name));
		
		Car c = (Car)criteria.uniqueResult();
		
		session.close();
		
		return c;
		
	}

}
