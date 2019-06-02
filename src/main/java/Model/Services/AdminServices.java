package Model.Services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import Model.Entities.Admin;
import Model.Entities.Person;
import Model.Entities.PlotDetail;

public class AdminServices {
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;
    
    public ArrayList<Person> getAllPersons()
    {
    	
    	session = sessionFactory.openSession();
    	
    	
    	List<Person> pers = session.createQuery("from Person").list();
    	
    	
    	session.close();
    	return (ArrayList<Person>) pers;
    }
    
    public ArrayList<PlotDetail> getAllPlotDetails()
    {
    	session = sessionFactory.openSession();
    	
    	List<PlotDetail> bookings = session.createQuery("from PlotDetail").list();
    	
    	session.close();
    	
    	return (ArrayList<PlotDetail>) bookings;
    }
    
    public boolean checkAdminCredentials(String user, String pass)
    {
    	session = sessionFactory.openSession();
    	
    	try {
    		
    		Criteria criteria = session.createCriteria(Admin.class)
    				.add(Restrictions.eq("userA",user))
    				.add(Restrictions.eq("passA", pass));
    		
    		Admin p = (Admin)criteria.uniqueResult();
        	System.out.println(p.getName());
    		
    	}catch(Exception e)
    	{
    		System.out.println("Wrong username or password");	
    		return false;
    	}

    	session.close();
    	
    	return true;
    }

}
