package Model.Repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Admin;
import Model.Entities.Parking;
import Model.Entities.Plot;

public class ParkingCRUD implements MasterInterface<Parking, Integer>{
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;

	public void create(Parking obiect) {
		System.out.println("Creating new Parking record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Parking> selectAll(){
		session = sessionFactory.openSession();
		
		Query q = session.createQuery("SELECT * FROM Parking");
		List<Parking> a = q.list();
		return a;
	}
	
	public Parking read(Integer idObiect) {
		Parking p;
		
		System.out.println("Reading Parking record...");
		session = sessionFactory.openSession();

		p = (Parking)session.get(Parking.class, idObiect);
		
		session.close();
		
		return p;
	}

	public void update(Parking obiect) {
		System.out.println("Updating Parking...");
		session = sessionFactory.openSession();
		
		Parking p = (Parking) session.get(Parking.class, obiect.getParkId());
		
		p.setAdminName(obiect.getAdminName());
		//p.setPlots(obiect.getPlots());
		
		
		
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public void delete(Integer idObiect) {
		System.out.println("Deleting Parking record...");
		session = sessionFactory.openSession();
		
		Parking p = (Parking) session.get(Parking.class, idObiect);
		
		session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
		
		session.close();
		
	}

}