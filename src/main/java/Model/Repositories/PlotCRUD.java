package Model.Repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Person;
import Model.Entities.Plot;

public class PlotCRUD implements MasterInterface<Plot, Integer>{
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;

	public void create(Plot obiect) {
		System.out.println("Creating new plot record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Plot> selectAll(){
		session = sessionFactory.openSession();
		
		Query q = session.createQuery("SELECT * FROM Plot");
		List<Plot> a = q.list();
		return a;
	}
	
	public Plot read(Integer idObiect) {
		Plot p;
		
		System.out.println("Reading plot record...");
		session = sessionFactory.openSession();

		p = (Plot)session.get(Plot.class, idObiect);
		
		session.close();
		
		return p;
	}

	public void update(Plot obiect) {
		System.out.println("Updating plot...");
		session = sessionFactory.openSession();
		
		Plot p = (Plot) session.get(Plot.class, obiect.getPlotId());
		
		//p.setStartD(obiect.getStartD());
		//p.setDuration(obiect.getDuration());
		//p.setDate(obiect.getDate());
		p.setPrice(obiect.getPrice());
		//p.setCar(obiect.getCar());
		//p.setOccupied(obiect.getOccupiedState());
		
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public void delete(Integer idObiect) {
		System.out.println("Deleting plot record...");
		session = sessionFactory.openSession();
		
		Plot p = (Plot) session.get(Plot.class, idObiect);
		
		
		session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
		
		session.close();
		
	}

}
