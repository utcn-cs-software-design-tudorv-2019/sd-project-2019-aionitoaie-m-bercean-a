package Model.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Admin;

public class AdminCRUD implements MasterInterface<Admin, Integer>{
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;

	public void create(Admin obiect) {
		System.out.println("Creating new Admin record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<Admin> selectAll(){
		session = sessionFactory.openSession();
		
		Query q = session.createQuery("SELECT * FROM Admin");
		List<Admin> a = q.list();
		return a;
	}
	
	public Admin read(Integer idObiect) {
		Admin a;
		
		System.out.println("Reading Admin record...");
		session = sessionFactory.openSession();

		a = (Admin)session.get(Admin.class, idObiect);
		
		session.close();
		
		return a;
	}

	public void update(Admin obiect) {
		System.out.println("Updating Admin...");
		session = sessionFactory.openSession();
		
		Admin a = (Admin) session.get(Admin.class, obiect.getAdminId());
		
		a.setName(obiect.getName());
		a.setParking(obiect.getParking());
		
		session.beginTransaction();
		session.saveOrUpdate(a);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public void delete(Integer idObiect) {
		System.out.println("Deleting Admin record...");
		session = sessionFactory.openSession();
		
		Admin a = (Admin) session.get(Admin.class, idObiect);
		
		session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
		
		session.close();
		
	}

}